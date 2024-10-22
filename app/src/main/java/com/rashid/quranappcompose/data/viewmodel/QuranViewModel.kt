package com.rashid.quranappcompose.data.viewmodel

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import com.rashid.quranappcompose.data.model.JuzInfo
import com.rashid.quranappcompose.data.model.Surah
import com.rashid.quranappcompose.data.model.Verse
import com.rashid.quranappcompose.data.repository.QuranRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class QuranViewModel : ScreenModel {

    private val quranRepository = QuranRepository()


    fun getSurahList(context: Context): MutableStateFlow<List<Surah>> {
        quranRepository.getSurahData(context)
        return quranRepository.surahListState
    }

    fun getLoadingState(): MutableStateFlow<Boolean> {
        return quranRepository.loadingState
    }


    fun getCurrentSurahNumber(): Int {
        return quranRepository.currentSurah
    }

    fun setCurrentSurahNumber(surahNo: Int) {
        quranRepository.currentSurah = surahNo
    }


    fun getSurahVerse(): MutableStateFlow<List<Verse>> {
        quranRepository.getSurahVerses()
        return quranRepository.surahVersesState
    }


    fun getAllJuzInfos(context: Context): MutableStateFlow<List<JuzInfo>> {
        quranRepository.getAllJuzInfo(context)
        return quranRepository.allJuzInfo
    }


    fun setCurrentJuzUrl(url: String) {
        quranRepository.currentJuzUrl = url
    }

    fun getCurrentJuzUrl(): String {
        return quranRepository.currentJuzUrl
    }

}