package com.mobileuts.scroll.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
fun DetailScreen(
    friend: Friend,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
            IconButton(
                onClick = { onNavigateBack() },
                modifier = Modifier.size(48.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Kembali"
                )
        }

        Image(
            painter = painterResource(id = friend.imageResId),
            contentDescription = friend.name,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = friend.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = friend.date,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = friend.description,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    val contohTeman =

        Friend(
        id = 1,
        name = "Luthfi Sang Pencinta Wanita",
        date = "Dilan 1988",
        description = "Aku memang pencinta wanita namun ku bukan buaya, yang setia pada seribu gadis, ku hanya mencintai dia.",
        imageResId = R.drawable.luthfi,
        instagramUrl = "https://instagram.com"
        )

    DetailScreen(
        friend = contohTeman,
        onNavigateBack = {}
    )
}