package com.samuelchowi.domain.model

data class UITheme(
    val isDarkThemeEnabled: Boolean = false,
    val isSystemThemePreferred: Boolean = true,
    val isDynamicColorEnabled: Boolean = false
)