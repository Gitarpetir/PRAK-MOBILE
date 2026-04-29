package com.mobileuts.scroll.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileuts.scroll.R
import com.mobileuts.scroll.model.Friend
import com.mobileuts.scroll.ui.components.FriendCard

@Composable
fun MainScreen(
    friendList: List<Friend>,
    onNavigateToDetail: (Int) -> Unit,
    onOpenInstagram: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 48.dp)
    ) {
        item {
            Text(
                text = "My Friend",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 24.dp)
            ){
                items(friendList) { dataTeman ->
                    Box(
                        modifier = Modifier.fillParentMaxSize(0.95f)
                    ){
                        FriendCard(
                            friend = dataTeman,
                            onInstagramClick = { url ->
                                onOpenInstagram(url)
                            },
                            onDetailClick = { id ->
                                onNavigateToDetail(id)
                            }
                        )
                    }
                }
            }
        }
        item {
            Text(
                text = "All Friend",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        items(friendList) { dataTeman ->
            FriendCard(
                friend = dataTeman,
                onInstagramClick = { url ->
                    onOpenInstagram(url)
                },
                onDetailClick = { id ->
                    onNavigateToDetail(id)}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val listTemanDummy = listOf(
        Friend(
            id = 1,
            name = "Luthfi Sang Pencinta Wanita",
            date = "Dilan 1988",
            description = "Aku memang pencinta wanita namun ku bukan buaya, yang setia pada seribu gadis, ku hanya mencintai dia.",
            imageResId = R.drawable.luthfi,
            instagramUrl = "https://instagram.com"
        ),
        Friend(
            id = 2,
            name = "Andre Mukbang Semangka",
            date = "RBTI 2026",
            description = "Andre sedang memakan potongan 3/4 semangkah agar tubuhnya kuat",
            imageResId = R.drawable.andre,
            instagramUrl = "https://instagram.com"
        ),
        Friend(
            id = 3,
            name = "Azriel Akbar",
            date = "32 Desember",
            description = "Azriel membajak hp ku",
            imageResId = R.drawable.azriel,
            instagramUrl = "https://instagram.com"),
        Friend(
            id = 4,
            name = "Faqih",
            date = "Kada Ingat",
            description = "Faqih ketika diajak main ps",
            imageResId = R.drawable.faqih,
            instagramUrl = "https://instagram.com"
        ),
        Friend(
            id = 5,
            name = "Gezoy Kahim",
            date = "30 Februari",
            description = "Ghazi melet",
            imageResId = R.drawable.ghazi,
            instagramUrl = "https://instagram.com"
        ),
        Friend(
            id = 6,
            name = "Numerikafka",
            date = "Intinya E2C",
            description = "Foto bukti mengikuti E2C",
            imageResId = R.drawable.maul,
            instagramUrl = "https://instagram.com"
        ),
        Friend(
            id = 7,
            name = "Veast.",
            date = "Matkul Bu Mute",
            description = "Nafis pas masih maba hanyar",
            imageResId = R.drawable.nafis,
            instagramUrl = "https://instagram.com"
        ),
        Friend(
            id = 8,
            name = "Rakhatuy Athaluy",
            date = "Kada Ingat",
            description = "Ganti gaya rambut agar wanita kepincut",
            imageResId = R.drawable.rakha,
            instagramUrl = "https://instagram.com"
        ),
        Friend(
            id = 9,
            name = "Luckyboyy",
            date = "Claude 2012",
            description = "Blazing Duet From LUCKYBOYYY",
            imageResId = R.drawable.ulyani,
            instagramUrl = "https://instagram.com"
        )
    )

    MainScreen(
        friendList = listTemanDummy,
        onNavigateToDetail = {},
        onOpenInstagram = {}
    )
}



