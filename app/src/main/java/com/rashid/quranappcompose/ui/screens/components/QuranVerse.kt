package com.rashid.quranappcompose.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashid.quranappcompose.R
import com.rashid.quranappcompose.data.model.Verse
import com.rashid.quranappcompose.ui.theme.COLOR_PRIMARY_DARK

@Composable
fun QuranVerse(
    modifier: Modifier = Modifier,
    verse: Verse
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(CircleShape)
                .background(
                    Color(0xFFF3F3F5),
                    CircleShape
                )
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        COLOR_PRIMARY_DARK,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center

            ) {
                EnglishText(
                    text = "${verse.number.inSurah}",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Row(
                modifier = Modifier
            ) {

                VerseButton(icon = R.drawable.ic_share) {

                }
                VerseButton(icon = R.drawable.ic_play) {

                }
                VerseButton(icon = R.drawable.ic_save) {

                }
            }

        }

        ArabicText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            text = verse.text.arab,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 48.sp,
            textAlign = TextAlign.End
        )

        EnglishText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            text = verse.translation.en,
            color = Color.Black,
            fontSize = 24.sp,
            lineHeight = 48.sp,
            textAlign = TextAlign.Start
        )
    }

}


@Composable
fun VerseButton(modifier: Modifier = Modifier, icon: Int, onButtonClick: () -> Unit) {

    IconButton(onClick = {
        onButtonClick()
    }) {
        Image(painter = painterResource(id = icon), contentDescription = null)
    }

}