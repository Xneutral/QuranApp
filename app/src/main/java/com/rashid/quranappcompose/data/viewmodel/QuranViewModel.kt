package com.rashid.quranappcompose.data.viewmodel

import android.util.Log
import cafe.adriel.voyager.core.model.ScreenModel
import com.rashid.quranappcompose.data.model.JuzData
import com.rashid.quranappcompose.data.model.JuzResponse
import com.rashid.quranappcompose.data.model.Surah
import com.rashid.quranappcompose.data.model.SurahResponse
import com.rashid.quranappcompose.data.model.Verse
import com.rashid.quranappcompose.data.model.VerseResponse
import com.rashid.quranappcompose.network.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuranViewModel : ScreenModel {

    private var _surahListState = MutableStateFlow(emptyList<Surah>())
    val surahListState get() = _surahListState

    private var _loadingState = MutableStateFlow(true)
    val loadingState get() = _loadingState

    private var _surahVersesState = MutableStateFlow(emptyList<Verse>())
    val surahVersesState get() = _surahVersesState


    private var _juzVersesState = MutableStateFlow(emptyList<Verse>())
    val juzVersesState get() = _juzVersesState

    var currentSurah = 0

    var currentJuz = 0

    val currentJuzInfo : MutableStateFlow<JuzData?> = MutableStateFlow(null)

    init {
        getSurahList()
    }

    fun getSurahList() {
        _loadingState.value = true
        RetrofitInstance.api.getSurahList().enqueue(object : Callback<SurahResponse> {
            override fun onResponse(call: Call<SurahResponse>, response: Response<SurahResponse>) {
                if (response.isSuccessful) {
                    _surahListState.value = response.body()?.data ?: emptyList()
                    _loadingState.value = false
                }
            }

            override fun onFailure(callResponse: Call<SurahResponse>, e: Throwable) {
                Log.d("TAG", "onFailure: ${e.message} ")
            }
        })
    }

    fun getSurahVerses() {
        _loadingState.value = true
        RetrofitInstance.api.getSurahVerses(currentSurah)
            .enqueue(object : Callback<VerseResponse> {
                override fun onResponse(
                    call: Call<VerseResponse>,
                    response: Response<VerseResponse>
                ) {
                    if (response.isSuccessful) {
                        _surahVersesState.value = response.body()?.data?.verses ?: emptyList()
                        _loadingState.value = false
                    }
                }

                override fun onFailure(response: Call<VerseResponse>, p1: Throwable) {
                    Log.d("TAG", "onFailure:${p1.message} ")
                }
            })
    }

    val quranicParasEng = listOf(
        "Alif Lam Meem",
        "Sayaqool",
        "Tilkal Rusull",
        "Lan Tana Loo",
        "Wal Mohsanat",
        "Ya Ayyuhaallazeena Aamanu",
        "Wa Iza Samiu",
        "Wa Lau Annana",
        "Qad Aflaha",
        "Wa A’lamu",
        "Yatazeroon",
        "Wa Mamin Da’abat",
        "Wa Ma Ubrioo",
        "Rubama",
        "Subhanallazi",
        "Qal Alam",
        "Aqtarabatis Sa’ah",
        "Qadd Aflaha",
        "Wa Qalallazeena",
        "Amman Khalaq",
        "Utlu Ma Oohi",
        "Wa Manyaqnut",
        "Wa Maliyy",
        "Faman Azlam",
        "Elahe Yuruddo",
        "Ha’a Meem",
        "Qala Fama Khatbukum",
        "Qadd Aflaha",
        "Tabarakallazi",
        "Amma Yatasa’aloon"
    )

    val quranicParasArabic = listOf(
        "الم",
        "سيقول",
        "تلك الرسل",
        "لن تنالوا",
        "والمحصنات",
        "يا ايها الذين امنوا",
        "واذا سمعوا",
        "ولو انا",
        "قد افلح",
        "واعلموا",
        "يعتذرون",
        "وما من دابة",
        "وما ابريء",
        "ربما",
        "سبحان الذي",
        "قال الم",
        "اقتربت الساعة",
        "قد افلح",
        "وقال الذين",
        "امن خلق",
        "اتل ما اوحي",
        "ومن يقنت",
        "وما لي",
        "فمن اظلم",
        "اليه يرد",
        "حم",
        "قال فما خطبكم",
        "قد افلح",
        "تبارك الذي",
        "عم يتساءلون"
    )

    fun getJuz(){
        _loadingState.value = true
        RetrofitInstance.api.getJuz(currentJuz)
            .enqueue(object : Callback<JuzResponse> {

                override fun onResponse(call: Call<JuzResponse>, response: Response<JuzResponse>) {
                    if (response.isSuccessful) {
                        currentJuzInfo.value = response.body()?.data
                        _juzVersesState.value = response.body()?.data?.verses ?: emptyList()
                        _loadingState.value = false
                    }
                }

                override fun onFailure(p0: Call<JuzResponse>, p1: Throwable) {
                    Log.d("TAG", "onFailure:${p1.message} ")
                }
            })
    }

}