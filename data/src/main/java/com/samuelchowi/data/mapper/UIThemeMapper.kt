package com.samuelchowi.data.mapper

import com.samuelchowi.data.local.model.ThemeData
import com.samuelchowi.domain.model.UITheme

fun mapUITheme(input: ThemeData) =
    with(input) { UITheme(isDarkThemeEnabled, isSystemThemePreferred, isDynamicColorEnabled) }