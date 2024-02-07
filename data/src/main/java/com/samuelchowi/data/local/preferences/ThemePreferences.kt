package com.samuelchowi.data.local.preferences

import com.samuelchowi.data.local.model.ThemeData
import kotlinx.coroutines.flow.MutableStateFlow

interface ThemePreferences {
    val themeDataStream: MutableStateFlow<ThemeData>
    val themeData: ThemeData
}