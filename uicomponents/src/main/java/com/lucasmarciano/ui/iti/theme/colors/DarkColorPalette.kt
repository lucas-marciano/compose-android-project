package com.lucasmarciano.ui.iti.theme.colors

import androidx.compose.ui.graphics.Color

private val ColorDarkPrimary = Color(0xFF1C1B1F)
private val ColorDarkPrimaryVariant = Color(0xFF444444)
private val ColorDarkSecondary = Color(0xFF1C1B1F)
private val ColorDarkBackground = Color(0xFF1C1B1F)
private val ColorDarkSurface = Color(0xFF1C1B1F)
private val ColorDarkError = Color(0xFFF44336)
private val ColorDarkOnPrimary = Color(0xFFFFFBFE)
private val ColorDarkOnSecondary = Color(0xFFFFFBFE)
private val ColorDarkOnBackground = Color(0xFFFFFBFE)
private val ColorDarkOnSurface = Color(0xFFFFFBFE)
private val ColorDarkOnError = Color(0xFFFFFFFF)

val DarkColorPalette = ColorsMainTheme(
    brand = ColorDarkPrimary,
    brandVariant = ColorDarkPrimaryVariant,
    variation = ColorDarkSecondary,
    bg = ColorDarkBackground,
    bgVariant = ColorDarkSurface,
    errorBg = ColorDarkError,
    onBrand = ColorDarkOnPrimary,
    onBrandVariant = ColorDarkOnSecondary,
    onBg = ColorDarkOnBackground,
    onBgVariant = ColorDarkOnSurface,
    onErrorBg = ColorDarkOnError,
    isDark = true
)
