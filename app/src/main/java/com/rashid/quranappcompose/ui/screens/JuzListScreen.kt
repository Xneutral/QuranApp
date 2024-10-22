package com.rashid.quranappcompose.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.rashid.quranappcompose.LocalViewModel
import com.rashid.quranappcompose.data.model.JuzData
import com.rashid.quranappcompose.ui.screens.components.JuzItem
import com.rashid.quranappcompose.ui.screens.components.QuranHeader
import com.rashid.quranappcompose.ui.screens.components.SurahItem


class JuzListScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val viewModel = LocalViewModel.current

        val juzList by viewModel.getAllJuzInfos(LocalContext.current).collectAsState()

        LazyColumn(
            modifier = Modifier
        ) {
            item {
                QuranHeader()
            }
            items(juzList.size) { index ->
                val topPadding = if (index == 0) 8.dp else 0.dp
                JuzItem(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .padding(top = topPadding),
                    juzList[index]
                ) {  link ->
                    viewModel.setCurrentJuzUrl(link)
                    navigator.push(JuzScreen())
                }
            }

        }
    }
}