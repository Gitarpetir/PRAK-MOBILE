package com.example.daducompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.daducompose.ui.theme.DaduComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DaduComposeTheme {
                DiceWithButtonAndImage(
                    modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var angkaDadu1 by remember { mutableStateOf(0) }
    var angkaDadu2 by remember { mutableStateOf(0) }
    val context = LocalContext.current
    val gambarDadu1 = when (angkaDadu1) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_0
    }

    val gambarDadu2 = when (angkaDadu2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_0
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Image(
                painter = painterResource(id = gambarDadu1),
                contentDescription = "Dadu 1"
            )

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = gambarDadu2),
                contentDescription = "Dadu 2"
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            angkaDadu1 = (1..6).random()
            angkaDadu2 = (1..6).random()

            if (angkaDadu1 == angkaDadu2) {
                Toast.makeText(context, "Selamat, anda dapat dadu double!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Roll")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceWithButtonAndImagePreview() {
    DaduComposeTheme {
        DiceWithButtonAndImage(
            modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
        )
    }
}
