package com.rashid.quranappcompose.ui.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.rashid.quranappcompose.R
import com.rashid.quranappcompose.ui.screens.JuzListScreen
import com.rashid.quranappcompose.ui.screens.JuzScreen
import com.rashid.quranappcompose.ui.screens.SurahListScreen


object JuzListTab : Tab {


    override val options: TabOptions
        @Composable
        get() {
            val title = "Juz List"
            val icon = painterResource(R.drawable.ic_read)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(JuzListScreen()) { navigator ->
            SlideTransition(navigator = navigator)
        }
    }

}