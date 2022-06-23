package com.lucasmarciano.ui.iti.theme.colors

import androidx.compose.ui.graphics.Color

private val ColorPrimary = Color(0xFFFFFBFE)
private val ColorPrimaryVariant = Color(0xFFFFFBFE)
private val ColorSecondary = Color(0xFFFFFBFE)
private val ColorBackground = Color(0xFFFFFBFE)
private val ColorSurface = Color(0xFFE8E2E6)
private val ColorError = Color(0xFFF44336)
private val ColorOnPrimary = Color(0xFF1C1B1F)
private val ColorOnSecondary = Color(0xFF1C1B1F)
private val ColorOnBackground = Color(0xFF1C1B1F)
private val ColorOnSurface = Color(0x401C1B1F)
private val ColorOnError = Color(0x401C1B1F)

val LightColorPalette = ColorsMainTheme(
    brand = ColorPrimary,
    brandVariant = ColorPrimaryVariant,
    variation = ColorSecondary,
    bg = ColorBackground,
    bgVariant = ColorSurface,
    errorBg = ColorError,
    onBrand = ColorOnPrimary,
    onBrandVariant = ColorOnSecondary,
    onBg = ColorOnBackground,
    onBgVariant = ColorOnSurface,
    onErrorBg = ColorOnError,
    isDark = false
)
