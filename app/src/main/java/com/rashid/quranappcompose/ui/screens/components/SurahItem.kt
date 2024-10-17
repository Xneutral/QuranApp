package com.rashid.quranappcompose.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashid.quranappcompose.R
import com.rashid.quranappcompose.data.model.Surah
import com.rashid.quranappcompose.ui.theme.COLOR_PRIMARY_DARK


@Composable
fun SurahItem(
    modifier: Modifier = Modifier,
    surah: Surah,
    onSurahItemClick: (surahNo : Int) -> Unit) {

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable { onSurahItemClick(surah.number) }
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = null
                )
                EnglishText(
                    text = "${surah.number}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {

                EnglishText(
                    text = surah.name.transliteration.en,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    EnglishText(
                        text = surah.revelation.en,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .clip(CircleShape)
                            .alpha(0.2f)
                            .background(Color.Gray)
                            .size(8.dp)


                    )

                    EnglishText(
                        text = "${surah.numberOfVerses} Verses",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            ArabicText(
                modifier = Modifier.weight(1f),
                text = surah.name.short,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = COLOR_PRIMARY_DARK,
                textAlign = TextAlign.End
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(top = 8.dp)
        )
    }

}