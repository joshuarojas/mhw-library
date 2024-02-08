package com.samuelchowi.data.local.model

data class ThemeData(
    val isDarkThemeEnabled: Boolean = false,
    val isSystemThemePreferred: Boolean = true,
    val isDynamicColorEnabled: Boolean = false
)