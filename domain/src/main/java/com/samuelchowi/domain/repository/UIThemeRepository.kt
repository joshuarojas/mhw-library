package com.samuelchowi.domain.repository

import com.samuelchowi.domain.model.UITheme
import kotlinx.coroutines.flow.Flow


interface UIThemeRepository {
    val themeDataStream: Flow<UITheme>
    suspend fun updateUITheme(isSystemDefaultEnabled: Boolean = false, isDarkThemeEnabled: Boolean = true)
}