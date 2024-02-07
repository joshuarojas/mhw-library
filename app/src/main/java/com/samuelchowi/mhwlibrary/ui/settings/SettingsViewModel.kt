package com.samuelchowi.mhwlibrary.ui.settings

import androidx.lifecycle.ViewModel
import com.samuelchowi.data.local.model.ThemeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    private val _themeDataState = MutableStateFlow<ThemeData>(ThemeData())
    val themeDataState = _themeDataState.asStateFlow()
}