package com.lucasmarciano.iti_theme.colors

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import com.lucasmarciano.core.theme.IColor

sealed interface IColorsStructure : IColor {
    override val brand: Color
    override val brandVariant: Color
    override val variation: Color
    override val bg: Color
    override val bgVariant: Color
    override val errorBg: Color
    override val onBrand: Color
    override val onBrandVariant: Color
    override val onBg: Color
    override val onBgVariant: Color
    override val onErrorBg: Color
    override val isDark: Boolean
}

fun localLibColor(isDark: Boolean): ProvidableCompositionLocal<IColor> =
    compositionLocalOf { if (isDark) DarkColorPalette() else LightColorPalette() }
