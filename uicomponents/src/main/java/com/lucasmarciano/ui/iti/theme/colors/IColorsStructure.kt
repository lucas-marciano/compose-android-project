package com.lucasmarciano.ui.iti.theme.colors

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

sealed interface IColorsStructure {
    val brand: Color
    val brandVariant: Color
    val variation: Color
    val bg: Color
    val bgVariant: Color
    val errorBg: Color
    val onBrand: Color
    val onBrandVariant: Color
    val onBg: Color
    val onBgVariant: Color
    val onErrorBg: Color
    val isDark: Boolean
}

@Composable
fun localLibColor(isDark: Boolean = isSystemInDarkTheme()) =
    compositionLocalOf { if (isDark) DarkColorPalette() else LightColorPalette() }