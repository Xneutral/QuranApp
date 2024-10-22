package com.rashid.quranappcompose.data.model


data class JuzResponse(
    val code: Int,
    val status: String,
    val message: String,
    val data: JuzData
)

data class JuzData(
    val juz: Int,
    val juzStartSurahNumber: Int,
    val juzEndSurahNumber: Int,
    val juzStartInfo: String,
    val juzEndInfo: String,
    val totalVerses: Int,
    val verses: List<Verse>
)

data class JuzInfo(
    val juzNo : Int,
    val arab : String,
    val en : String,
    val totalVerses: Int,
    val pdfLink: String,
)


data class JuzInfoList(
    val paras : List<JuzInfo>
)