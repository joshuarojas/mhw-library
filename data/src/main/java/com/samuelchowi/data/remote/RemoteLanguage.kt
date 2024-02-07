package com.samuelchowi.data.remote

import com.samuelchowi.data.local.model.LanguageData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteLanguage @Inject constructor() {
    private var language: LanguageData = LanguageData.English()

    fun updateLanguage(language: LanguageData) {
        this.language = language
    }

    fun getLanguage() = language.key
}