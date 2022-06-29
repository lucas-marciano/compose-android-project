package com.lucasmarciano.core.theme

import androidx.compose.ui.graphics.Color

interface IColor {
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
