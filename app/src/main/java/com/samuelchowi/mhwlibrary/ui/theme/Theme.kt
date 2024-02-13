package com.samuelchowi.mhwlibrary.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.samuelchowi.mhwlibrary.ui.main.MainViewModel

private val LightColorScheme = lightColorScheme(
    primary = md_theme_primary_light,
    onPrimary = md_theme_onPrimary_light,
    primaryContainer = md_theme_primaryContainer_light,
    onPrimaryContainer = md_theme_onPrimaryContainer_light,
    secondary = md_theme_secondary_light,
    onSecondary = md_theme_onSecondary_light,
    secondaryContainer = md_theme_secondaryContainer_light,
    onSecondaryContainer = md_theme_onSecondaryContainer_light,
    tertiary = md_theme_tertiary_light,
    onTertiary = md_theme_onTertiary_light,
    tertiaryContainer = md_theme_tertiaryContainer_light,
    onTertiaryContainer = md_theme_onTertiaryContainer_light,
    error = md_theme_error_light,
    onError = md_theme_onError_light,
    background = md_theme_background_light,
    onBackground = md_theme_onBackground_light,
    surface = md_theme_surface_light,
    onSurface = md_theme_onSurface_light,
    surfaceVariant = md_theme_SurfaceVariant_light,
    onSurfaceVariant = md_theme_onSurfaceVariant_light,
    outline = md_theme_outline_light,
)

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_primary_dark,
    onPrimary = md_theme_onPrimary_dark,
    primaryContainer = md_theme_primaryContainer_dark,
    onPrimaryContainer = md_theme_onPrimaryContainer_dark,
    secondary = md_theme_secondary_dark,
    onSecondary = md_theme_onSecondary_dark,
    secondaryContainer = md_theme_secondaryContainer_dark,
    onSecondaryContainer = md_theme_onSecondaryContainer_dark,
    tertiary = md_theme_tertiary_dark,
    onTertiary = md_theme_onTertiary_dark,
    tertiaryContainer = md_theme_tertiaryContainer_dark,
    onTertiaryContainer = md_theme_onTertiaryContainer_dark,
    error = md_theme_error_dark,
    onError = md_theme_onError_dark,
    background = md_theme_background_dark,
    onBackground = md_theme_onBackground_dark,
    surface = md_theme_surface_dark,
    onSurface = md_theme_onSurface_dark,
    surfaceVariant = md_theme_SurfaceVariant_dark,
    onSurfaceVariant = md_theme_onSurfaceVariant_dark,
    outline = md_theme_outline_dark,
)

@Composable
fun MHWLibraryTheme(
    mainViewModel: MainViewModel = hiltViewModel(),
    content: @Composable () -> Unit
) {
    val isSystemDarkModeEnabled = isSystemInDarkTheme()
    val themeData by mainViewModel.themeDataState.collectAsStateWithLifecycle()
    val colorScheme = with(themeData) {
        when {
            isDynamicColorEnabled && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (isSystemThemePreferred) {
                    if (isSystemDarkModeEnabled) dynamicDarkColorScheme(context)
                    else dynamicLightColorScheme(context)
                } else if (isDarkThemeEnabled) {
                    dynamicDarkColorScheme(context)
                } else {
                    dynamicLightColorScheme(context)
                }
            }

            isSystemThemePreferred -> {
                if (isSystemDarkModeEnabled) DarkColorScheme
                else LightColorScheme
            }

            isDarkThemeEnabled -> DarkColorScheme
            else -> LightColorScheme
        }
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                if (themeData.isSystemThemePreferred) isSystemDarkModeEnabled.not()
                else themeData.isDarkThemeEnabled.not()
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
