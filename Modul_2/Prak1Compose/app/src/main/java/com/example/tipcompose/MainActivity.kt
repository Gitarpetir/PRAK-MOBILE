package com.example.tipcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.ceil
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Icon


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KalkulatorTipApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KalkulatorTipApp() {
    var inputBiaya by rememberSaveable { mutableStateOf("") }
    var persentaseTip by rememberSaveable { mutableStateOf(15) }
    var bulatkanKeAtas by rememberSaveable { mutableStateOf(false) }
    var menuTerbuka by rememberSaveable { mutableStateOf(false) }

    val jumlahBiaya = inputBiaya.toDoubleOrNull() ?: 0.0
    var jumlahTip = jumlahBiaya * (persentaseTip / 100.0)

    if (bulatkanKeAtas) {
        jumlahTip = ceil(jumlahTip)
    }

    val tipDifomat = NumberFormat.getCurrencyInstance(Locale.US).format(jumlahTip)

    val pilihanTip = listOf(15, 18, 20)

    Column(
        modifier = Modifier.padding(32.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculate Tip",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = inputBiaya,
            onValueChange = { inputBiaya = it },
            label = { Text("Bill Amount") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.bill_amount),
                    contentDescription = "Bill amount"
                )
            },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        ExposedDropdownMenuBox(
            expanded = menuTerbuka,
            onExpandedChange = { menuTerbuka = !menuTerbuka },
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            TextField(
                value = "$persentaseTip%",
                onValueChange = {},
                readOnly = true,
                label = { Text("Tip Percentage") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.tip_persen),
                        contentDescription = "Tip Percentage"
                        )
                },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = menuTerbuka) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = menuTerbuka,
                onDismissRequest = { menuTerbuka = false }
            ) {
                pilihanTip.forEach { pilihan ->
                    DropdownMenuItem(
                        text = { Text("$pilihan%") },
                        onClick = {
                            persentaseTip = pilihan
                            menuTerbuka = false
                        }
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Round up tip?")
            Switch(
                checked = bulatkanKeAtas,
                onCheckedChange = { bulatkanKeAtas = it }
            )
        }

        Text(
            text = "Tip Amount: $tipDifomat",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KalkulatorTipPreview() {
    MaterialTheme {
        KalkulatorTipApp()
    }
}