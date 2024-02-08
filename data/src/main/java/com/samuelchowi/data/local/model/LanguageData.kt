package com.samuelchowi.data.local.model

sealed class LanguageData(val key: String) {
    class English() : LanguageData("")
    class Spanish() : LanguageData("es/")
    class German() : LanguageData("de/")
    class French() : LanguageData("fr/")
    class Chinese() : LanguageData("zh/")
    class ChineseTraditional() : LanguageData("zh-Hant/")
}