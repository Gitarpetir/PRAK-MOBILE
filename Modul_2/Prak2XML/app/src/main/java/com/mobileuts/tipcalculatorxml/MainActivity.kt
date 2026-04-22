package com.mobileuts.tipcalculatorxml

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.textfield.TextInputEditText
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputBiaya: TextInputEditText = findViewById(R.id.inputBiaya)
        val dropdownTip: AutoCompleteTextView = findViewById(R.id.dropdownTip)
        val switchBulatkan: MaterialSwitch = findViewById(R.id.switchBulatkan)
        val teksHasil: TextView = findViewById(R.id.teksHasil)

        val pilihanTip = arrayOf("15%", "18%", "20%")
        dropdownTip.setAdapter(ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, pilihanTip))

        inputBiaya.doAfterTextChanged {
            hitungTip(inputBiaya, dropdownTip, switchBulatkan, teksHasil)
        }

        dropdownTip.setOnItemClickListener { _, _, _, _ ->
            hitungTip(inputBiaya, dropdownTip, switchBulatkan, teksHasil)
        }

        switchBulatkan.setOnCheckedChangeListener { _, _ ->
            hitungTip(inputBiaya, dropdownTip, switchBulatkan, teksHasil)
        }
    }

    private fun hitungTip(
        inputBiaya: TextInputEditText,
        dropdownTip: AutoCompleteTextView,
        switchBulatkan: MaterialSwitch,
        teksHasil: TextView
    ) {
        val biaya = inputBiaya.text.toString().toDoubleOrNull() ?: 0.0

        val persentase = dropdownTip.text.toString().replace("%", "").toDoubleOrNull() ?: 15.0

        var jumlahTip = biaya * (persentase / 100.0)

        if (switchBulatkan.isChecked) {
            jumlahTip = ceil(jumlahTip)
        }

        teksHasil.text = "Tip Amount: ${NumberFormat.getCurrencyInstance(Locale.US).format(jumlahTip)}"
    }
}