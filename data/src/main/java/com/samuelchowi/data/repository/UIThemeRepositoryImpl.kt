package com.samuelchowi.data.repository

import com.samuelchowi.data.local.model.ThemeData
import com.samuelchowi.data.local.preferences.ThemePreferences
import com.samuelchowi.data.mapper.mapUITheme
import com.samuelchowi.domain.model.UITheme
import com.samuelchowi.domain.repository.UIThemeRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ViewModelScoped
class UIThemeRepositoryImpl @Inject constructor(
    private val themePreferences: ThemePreferences
): UIThemeRepository {
    override val themeDataStream: Flow<UITheme> = themePreferences.themeDataStream.map(::mapUITheme)

    override suspend fun updateUITheme(isSystemDefaultEnabled: Boolean, isDarkThemeEnabled: Boolean) {
        themePreferences.themeData = ThemeData(isDarkThemeEnabled = isDarkThemeEnabled, isSystemThemePreferred = isSystemDefaultEnabled)
    }
}