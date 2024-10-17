package com.rashid.quranappcompose.data.model

data class VerseResponse(
    val code: Int,
    val status: String,
    val message: String,
    val data: VerseData
)

data class VerseNumber(
    val inQuran: Int,
    val inSurah: Int
)

data class VerseSajda(
    val recommended: Boolean,
    val obligatory: Boolean
)

data class VerseMeta(
    val juz: Int,
    val page: Int,
    val manzil: Int,
    val ruku: Int,
    val hizbQuarter: Int,
    val sajda: VerseSajda
)

data class VerseText(
    val arab: String,
    val transliteration: Transliteration
)


data class VerseTranslation(
    val en: String,
    val id: String
)

data class VerseAudio(
    val primary: String,
    val secondary: List<String>
)

data class TafsirId(
    val short: String,
    val long: String
)

data class VerseTafsir(
    val id: TafsirId
)

data class Verse(
    val number: VerseNumber,
    val meta: VerseMeta,
    val text: VerseText,
    val translation: VerseTranslation,
    val audio: VerseAudio,
    val tafsir: VerseTafsir
)

data class VerseData(
    val number: Int,
    val sequence: Int,
    val numberOfVerses: Int,
    val name: Name,
    val revelation: Revelation,
    val tafsir: Tafsir,
    val preBismillah: VerseText?,
    val verses: List<Verse>
)


