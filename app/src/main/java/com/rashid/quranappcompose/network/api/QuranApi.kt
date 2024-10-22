package com.rashid.quranappcompose.network.api

import com.rashid.quranappcompose.data.model.JuzResponse
import com.rashid.quranappcompose.data.model.SurahResponse
import com.rashid.quranappcompose.data.model.VerseResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface QuranApi {
    @GET("surah")
    fun getSurahList(): Response<SurahResponse>

    @GET("surah/{surahNumber}")
    fun getSurahVerses(@Path("surahNumber") surahNo : Int) : Call<VerseResponse>

    @GET("juz/{juzNo}")
    fun getJuz(@Path("juzNo") juzNo : Int) : Call<JuzResponse>


}


