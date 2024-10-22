package com.rashid.quranappcompose.network.apicalls

import android.content.Context
import android.util.Log
import com.rashid.quranappcompose.data.model.SurahResponse
import com.rashid.quranappcompose.data.model.Verse
import com.rashid.quranappcompose.data.model.VerseResponse
import com.rashid.quranappcompose.network.api.RetrofitInstance
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RetrofitUtil {


    suspend fun getSurahFromApi(): SurahResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<SurahResponse> = RetrofitInstance.api.getSurahList()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                e.printStackTrace() // Handle exceptions
                null
            }
        }
    }

    suspend fun getSurahVerses(surahNo: Int): List<Verse> {
        val deferred = CompletableDeferred<List<Verse>>()

        withContext(Dispatchers.IO) {
            RetrofitInstance.api.getSurahVerses(surahNo).enqueue(object : Callback<VerseResponse> {
                override fun onResponse(
                    call: Call<VerseResponse>,
                    response: Response<VerseResponse>
                ) {
                    if (response.isSuccessful) {
                        val verses = response.body()?.data?.verses ?: emptyList()
                        deferred.complete(verses)
                    } else {
                        deferred.complete(emptyList())
                    }
                }

                override fun onFailure(call: Call<VerseResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    deferred.complete(emptyList())
                }
            })
        }

        return deferred.await()
    }

}