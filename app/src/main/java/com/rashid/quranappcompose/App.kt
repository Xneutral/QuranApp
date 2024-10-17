package com.rashid.quranappcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.rashid.quranappcompose.data.viewmodel.QuranViewModel
import com.rashid.quranappcompose.ui.screens.SurahListScreen
import com.rashid.quranappcompose.ui.tabs.JuzListTab
import com.rashid.quranappcompose.ui.tabs.SurahListTab

data class ApplicationFonts(
    val englishFont: FontFamily? = null,
    val arabicFont: FontFamily? = null,
)

var AppFonts = ApplicationFonts()

val LocalViewModel = compositionLocalOf {
    QuranViewModel()
}

@Composable
fun App(modifier: Modifier = Modifier) {

    val englishFont = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_medium),
        Font(R.font.poppins_bold),
    )

    val arabicFont = FontFamily(
        Font(R.font.amiri_bold)
    )

    AppFonts = ApplicationFonts(
        englishFont = englishFont,
        arabicFont = arabicFont,
    )

    //Simple Navigation
//    Navigator(SurahListScreen()){navigator ->
//        SlideTransition(navigator = navigator)
//    }

    //Bottom Navigation (Tabs)

    TabNavigator(SurahListTab) {
        Scaffold(
            bottomBar = {
                BottomNavigation {
                    TabNavigationItem(SurahListTab)
                    TabNavigationItem(JuzListTab)
                }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.fillMaxSize().padding(innerPadding)){
                CurrentTab()
            }
        }
    }

}


@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) }
    )
}