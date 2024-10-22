package com.rashid.quranappcompose.data.repository

import android.content.Context
import com.google.gson.Gson
import com.rashid.quranappcompose.data.model.JuzInfo
import com.rashid.quranappcompose.data.model.JuzInfoList
import com.rashid.quranappcompose.data.model.Surah
import com.rashid.quranappcompose.data.model.SurahResponse
import com.rashid.quranappcompose.data.model.Verse
import com.rashid.quranappcompose.network.apicalls.RetrofitUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class QuranRepository {

    private var _surahListState = MutableStateFlow(emptyList<Surah>())
    val surahListState get() = _surahListState

    private var _loadingState = MutableStateFlow(true)
    val loadingState get() = _loadingState

    private var _surahVersesState = MutableStateFlow(emptyList<Verse>())
    val surahVersesState get() = _surahVersesState


    var currentSurah = 0
    private var previousSurah = 0

    var currentJuzUrl = ""

    val allJuzInfo: MutableStateFlow<List<JuzInfo>> = MutableStateFlow(listOf())


    fun getSurahVerses() {
        if (currentSurah != previousSurah) {
            _loadingState.value = true
            CoroutineScope(Dispatchers.IO)
                .launch {
                    previousSurah = currentSurah
                    _surahVersesState.value = RetrofitUtil.getSurahVerses(currentSurah)
                    _loadingState.value = false
                }
        }
    }



    fun getSurahData(context: Context) {
        _loadingState.value = true
        val jsonContent = context.assets.open(SURAH_LIST_JSON).use { it.reader().readText() }
        val surahResponse = Gson().fromJson(jsonContent, SurahResponse::class.java)
        surahListState.value = surahResponse.data
        _loadingState.value = false
    }

    fun getAllJuzInfo(context: Context) {
        val jsonContent = context.assets.open(PARA_LIST_JSON).use { it.reader().readText() }
        val juzResponse = Gson().fromJson(jsonContent, JuzInfoList::class.java)
        allJuzInfo.value = juzResponse.paras
    }


    companion object {
        const val SURAH_LIST_JSON = "surahList.json"
        const val PARA_LIST_JSON = "paras_info.json"
    }

}