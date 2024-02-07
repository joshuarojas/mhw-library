package com.samuelchowi.mhwlibrary.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.samuelchowi.mhwlibrary.R


val barlowFontFamily = FontFamily(
    Font(R.font.barlow_regular, FontWeight.Normal),
    Font(R.font.barlow_medium, FontWeight.Medium),
    Font(R.font.barlow_light, FontWeight.Light),
    Font(R.font.barlow_thinitalic, FontWeight.Thin, FontStyle.Italic),
)

val quickSandFontFamily = FontFamily(
    Font(R.font.quicksand_bold, FontWeight.Bold),
    Font(R.font.quicksand_medium, FontWeight.Medium),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = barlowFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = barlowFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = barlowFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 19.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = barlowFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = barlowFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = barlowFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    ),
)