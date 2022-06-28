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

data class DarkColorPalette(
    override val brand: Color = ColorDarkPrimary,
    override val brandVariant: Color = ColorDarkPrimaryVariant,
    override val variation: Color = ColorDarkSecondary,
    override val bg: Color = ColorDarkBackground,
    override val bgVariant: Color = ColorDarkSurface,
    override val errorBg: Color = ColorDarkError,
    override val onBrand: Color = ColorDarkOnPrimary,
    override val onBrandVariant: Color = ColorDarkOnSecondary,
    override val onBg: Color = ColorDarkOnBackground,
    override val onBgVariant: Color = ColorDarkOnSurface,
    override val onErrorBg: Color = ColorDarkOnError,
    override val isDark: Boolean = false
) : IColorsStructure

internal val darkColorPalette = DarkColorPalette()
