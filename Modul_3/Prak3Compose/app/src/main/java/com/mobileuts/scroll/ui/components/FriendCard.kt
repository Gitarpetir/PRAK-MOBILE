package com.mobileuts.scroll.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileuts.scroll.model.Friend
import com.mobileuts.scroll.R

@Composable
fun FriendCard(
    friend: Friend,
    onInstagramClick: (String) -> Unit,
    onDetailClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ){
            Image(
                painter = painterResource(id = friend.imageResId),
                contentDescription = "Foto Profil",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column (modifier = Modifier.weight(1f)) {
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = friend.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f).padding(end = 8.dp)
                    )

                    Text(
                        text = friend.date,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = friend.description,
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Button(
                        onClick = { onInstagramClick(friend.instagramUrl)},
                        modifier = Modifier.height(36.dp)
                    ) {
                        Text(
                            text = "Instagram",
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))

                    Button(
                        onClick = { onDetailClick(friend.id) },
                        modifier = Modifier.height(36.dp)
                    ){
                        Text(
                            text = "Detail",
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FriendCardPreview() {
    val dummyFriend = Friend(
        id = 1,
        name = "Muhammad Rakha Athallah ",
        date = "Agustus 1945",
        description = "Hebat Mantap Luar Biasa ALLAHUAKBAR",
        imageResId = R.drawable.rakha,
        instagramUrl = "https://instagram.com"
    )

    FriendCard(
        friend = dummyFriend,
        onInstagramClick = {},
        onDetailClick = {}
    )
}