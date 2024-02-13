package com.samuelchowi.mhwlibrary.ui.settings

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuelchowi.domain.model.UITheme
import com.samuelchowi.domain.repository.UIThemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val uiThemeRepository: UIThemeRepository
) : ViewModel() {

    val themeDataState =
        uiThemeRepository.themeDataStream.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), UITheme())

    private val _languageDataState = MutableStateFlow(AppCompatDelegate.getApplicationLocales())
    val languageDataState = _languageDataState.asStateFlow()

    fun updateThemeData(
        isDarkThemeEnabled: Boolean? = null,
        isSystemPreferredEnabled: Boolean? = null,
    ) {
        viewModelScope.launch {
            uiThemeRepository.updateUITheme(
                isDarkThemeEnabled = isDarkThemeEnabled ?: themeDataState.value.isDarkThemeEnabled,
                isSystemDefaultEnabled = isSystemPreferredEnabled ?: themeDataState.value.isSystemThemePreferred,
            )
        }
    }

    fun updateAppLanguage(stringLocale: String) {
        AppCompatDelegate.setApplicationLocales(
            if (stringLocale.isEmpty()) LocaleListCompat.getEmptyLocaleList()
            else LocaleListCompat.forLanguageTags(stringLocale)
        )
    }
}