package com.mobileuts.scroll

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mobileuts.scroll.model.Friend
import com.mobileuts.scroll.ui.screen.DetailScreen
import com.mobileuts.scroll.ui.screen.MainScreen

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val friend = getDummyFriends()
            var selectedFriendId by rememberSaveable { mutableStateOf<Int?>(null) }

            MaterialTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (selectedFriendId == null) {
                        MainScreen(
                            friendList = friend,
                            onNavigateToDetail = { id ->
                                selectedFriendId = id
                            },
                            onOpenInstagram = { url ->
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                startActivity(intent)
                            }
                        )
                    } else {
                    val selectedFriend = friend.find { it.id == selectedFriendId }
                        if (selectedFriend != null) {
                            DetailScreen(
                                friend = selectedFriend,
                                onNavigateBack = { selectedFriendId = null }
                            )
                        }
                    }
                }
            }
        }
        }
}

fun getDummyFriends(): List<Friend>{
    return listOf(
        Friend(
            id = 1,
            name = "Luthfi Sang Pencinta Wanita",
            date = "Dilan 1988",
            description = "Aku memang pencinta wanita namun ku bukan buaya, yang setia pada seribu gadis, ku hanya mencintai dia.",
            imageResId = R.drawable.luthfi,
            instagramUrl = "https://www.instagram.com/aluthfi_m?igsh=cWtwd3p6YmpsdjZh"
        ),
        Friend(
            id = 2,
            name = "Andre Mukbang Semangka",
            date = "RBTI 2026",
            description = "Andre sedang memakan potongan 3/4 semangkah agar tubuhnya kuat",
            imageResId = R.drawable.andre,
            instagramUrl = "https://www.instagram.com/andrecrnth?igsh=MWozZWRqbWlkZG02Yg=="
        ),
        Friend(
            id = 3,
            name = "Azriel Akbar",
            date = "32 Desember",
            description = "Azriel membajak hp ku dan memfoto muhanya",
            imageResId = R.drawable.azriel,
            instagramUrl = "https://www.instagram.com/akbzrl?igsh=MWJsMGw0dThmNmE3bA=="
        ),
        Friend(
            id = 4,
            name = "Faqih",
            date = "Kada Ingat",
            description = "Faqih ketika diajak main ps",
            imageResId = R.drawable.faqih,
            instagramUrl = "https://www.instagram.com/faqihazma?igsh=MWd2NDB3bXQ3Zm5kMw=="
        ),
        Friend(
            id = 5,
            name = "Gezoy Kahim",
            date = "30 Februari",
            description = "Ghazi melet kada tahu gasan apa",
            imageResId = R.drawable.ghazi,
            instagramUrl = "https://www.instagram.com/muh.ghazii?igsh=eWxqazRiNTlmOW9s"
        ),
        Friend(
            id = 6,
            name = "Numerikafka",
            date = "Intinya E2C",
            description = "Foto bukti mengikuti E2C",
            imageResId = R.drawable.maul,
            instagramUrl = "https://www.instagram.com/maulanazhaari?igsh=MWY4czM2Y2NmaW1iMQ=="
        ),
        Friend(
            id = 7,
            name = "Veast.",
            date = "Matkul Bu Mute",
            description = "Nafis pas masih maba baru",
            imageResId = R.drawable.nafis,
            instagramUrl = "https://www.instagram.com/nfisp?igsh=MWN6OW1ocndpNHVkNw=="
        ),
        Friend(
            id = 8,
            name = "Rakhatuy Athaluy",
            date = "Kada Ingat",
            description = "Ganti gaya rambut agar wanita kepincut",
            imageResId = R.drawable.rakha,
            instagramUrl = "https://www.instagram.com/raakhatha?igsh=MTg0bXhzdjhteGlrNw=="
        ),
        Friend(
            id = 9,
            name = "Luckyboyy",
            date = "Claude 2012",
            description = "Blazing Duet From LUCKYBOYYY",
            imageResId = R.drawable.ulyani,
            instagramUrl = "https://www.instagram.com/yanwinterr?igsh=MTVpbHUzcWo0bDB1Yg=="
        )
    )
}