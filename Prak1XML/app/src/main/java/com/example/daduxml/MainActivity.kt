package com.example.daduxml

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val daduSatu = findViewById<ImageView>(R.id.daduSatu)
        val daduDua = findViewById<ImageView>(R.id.daduDua)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val angkaDadu1 = (1..6).random()
            val angkaDadu2 = (1..6).random()

            val sumberGambar1 = when (angkaDadu1) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.dice_0
            }

            val sumberGambar2 = when (angkaDadu2) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.dice_0
            }

            daduSatu.setImageResource(sumberGambar1)
            daduDua.setImageResource(sumberGambar2)

            if (angkaDadu1 == angkaDadu2) {
                Toast.makeText(this, "Selamat, anda dapat dadu double!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
