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
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.rashid.quranappcompose.LocalViewModel
import com.rashid.quranappcompose.ui.screens.components.QuranHeader
import com.rashid.quranappcompose.ui.screens.components.QuranVerse
import com.rashid.quranappcompose.ui.screens.components.SurahHeader
import com.rashid.quranappcompose.ui.screens.components.SurahItem


class JuzScreen : Screen {

    @Composable
    override fun Content() {

        val viewModel = LocalViewModel.current
        val juzVerseList by viewModel.juzVersesState.collectAsState()

        val loading by viewModel.loadingState.collectAsState()

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
//                    SurahHeader(
//                        modifier = Modifier,
//                        surah = juzVerseList[viewModel.currentSurah.minus(1)]
//                    )
                }
                items(juzVerseList) { verse ->
                    QuranVerse(modifier = Modifier, verse)
                }
            }

        }

    }

}