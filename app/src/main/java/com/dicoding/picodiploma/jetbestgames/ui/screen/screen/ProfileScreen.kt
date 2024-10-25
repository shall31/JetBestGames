package com.dicoding.picodiploma.jetbestgames.ui.screen.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.picodiploma.jetbestgames.R

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "About",
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 24.sp
        )
        Box {
            Image(
                painter = painterResource(R.drawable.me),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier.height(IntrinsicSize.Max)
                    .clip(shape = CircleShape)
                    .padding(vertical = 50.dp)
            )

        }
        Text(
            text = "Gusti Aqhsal Mujahid",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 28.sp
        )
        Text(
            text = "aqshalgusti31@gmail.com",
            style = MaterialTheme.typography.bodySmall,
            fontSize = 16.sp
        )
        Text(
            text = "@gaqshal",
            style = MaterialTheme.typography.bodySmall,
            fontSize = 16.sp
        )
    }
}