package com.rashid.quranappcompose.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.rashid.quranappcompose.LocalViewModel
import com.rashid.quranappcompose.ui.screens.components.QuranHeader
import com.rashid.quranappcompose.ui.screens.components.QuranVerse
import com.rashid.quranappcompose.ui.screens.components.SurahHeader
import com.rashid.quranappcompose.ui.screens.components.SurahItem

class SurahScreen : Screen {

    @Composable
    override fun Content() {

        val viewModel = LocalViewModel.current

        val context =  LocalContext.current
        val surahList by viewModel.getSurahList(context).collectAsState()
        val verseList by viewModel.getSurahVerse().collectAsState()

        val loading by viewModel.getLoadingState().collectAsState()

        if (loading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }

        } else {
            LazyColumn(
                modifier = Modifier
            ) {
                item {
                    SurahHeader(
                        modifier = Modifier,
                        surah = surahList[viewModel.getCurrentSurahNumber().minus(1)]
                    )

                }
                items(verseList) { verse ->
                    QuranVerse(modifier = Modifier, verse)
                }
            }

        }

    }

}