package com.rashid.quranappcompose.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashid.quranappcompose.R
import com.rashid.quranappcompose.data.model.Surah
import com.rashid.quranappcompose.ui.theme.COLOR_PRIMARY_DARK
import com.rashid.quranappcompose.ui.theme.COLOR_PRIMARY_LIGHT

@Composable
fun SurahHeader(
    modifier: Modifier = Modifier,
    surah : Surah
) {

    Column {

        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(320.dp)
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
                        .alpha(0.25f)
                        .align(Alignment.BottomEnd)
                        .offset(100.dp, 70.dp)
                        .size(400.dp)

                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(top = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        EnglishText(
                            text = surah.name.transliteration.en,
                            fontSize = 26.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        EnglishText(
                            text = surah.name.translation.en,
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        HorizontalDivider(
                            modifier = Modifier
                                .padding(vertical = 16.dp, horizontal = 72.dp),
                            thickness = 0.5.dp
                        )

                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            EnglishText(
                                text = surah.revelation.en,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                                    .size(8.dp)


                            )

                            EnglishText(
                                text = "${surah.numberOfVerses} Verses",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        painter = painterResource(id = R.drawable.ic_bismillah),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Bismillah"
                    )

                }


            }


        }
    }

}