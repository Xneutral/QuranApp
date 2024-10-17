package com.rashid.quranappcompose.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashid.quranappcompose.R
import com.rashid.quranappcompose.ui.theme.COLOR_PRIMARY_DARK
import com.rashid.quranappcompose.ui.theme.COLOR_PRIMARY_LIGHT

@Composable
fun QuranHeader(modifier: Modifier = Modifier) {

    Column {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                COLOR_PRIMARY_LIGHT,
                                COLOR_PRIMARY_DARK
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_quran),
                    contentDescription = "Quran",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(240.dp)
                        .offset(40.dp, 40.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_read),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            EnglishText(
                                text = "Last Read",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                            )
                        }

                        EnglishText(
                            text = "Al-Fatiha",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 34.sp
                        )

                        EnglishText(
                            text = "Ayah No: 1",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp
                        )

                    }
                }

            }
        }
    }

}