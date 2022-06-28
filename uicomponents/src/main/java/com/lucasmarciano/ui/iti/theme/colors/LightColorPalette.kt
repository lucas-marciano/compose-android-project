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

data class LightColorPalette(
    override val brand: Color = ColorPrimary,
    override val brandVariant: Color = ColorPrimaryVariant,
    override val variation: Color = ColorSecondary,
    override val bg: Color = ColorBackground,
    override val bgVariant: Color = ColorSurface,
    override val errorBg: Color = ColorError,
    override val onBrand: Color = ColorOnPrimary,
    override val onBrandVariant: Color = ColorOnSecondary,
    override val onBg: Color = ColorOnBackground,
    override val onBgVariant: Color = ColorOnSurface,
    override val onErrorBg: Color = ColorOnError,
    override val isDark: Boolean = false
) : IColorsStructure

internal val lightColorPalette = LightColorPalette()
