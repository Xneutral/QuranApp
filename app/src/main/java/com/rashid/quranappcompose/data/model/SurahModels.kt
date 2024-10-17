package com.rashid.quranappcompose.data.model

data class SurahResponse(
    val code: Int,
    val status: String,
    val message: String,
    val data: List<Surah>
)

data class Surah(
    val number: Int,
    val sequence: Int,
    val numberOfVerses: Int,
    val name: Name,
    val revelation: Revelation,
    val tafsir: Tafsir
)

data class Name(
    val short: String,
    val long: String,
    val transliteration: Transliteration,
    val translation: Translation
)

data class Transliteration(
    val en: String,
    val id: String
)

data class Translation(
    val en: String,
    val id: String
)

data class Revelation(
    val arab: String,
    val en: String,
    val id: String
)

data class Tafsir(
    val id: String
)
