package com.lucasmarciano.ui.iti.theme.colors

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
class ColorsMainTheme(
    brand: Color,
    brandVariant: Color,
    variation: Color,
    bg: Color,
    bgVariant: Color,
    errorBg: Color,
    onBrand: Color,
    onBrandVariant: Color,
    onBg: Color,
    onBgVariant: Color,
    onErrorBg: Color,
    isDark: Boolean
) {
    var brand by mutableStateOf(brand)
        private set
    var brandVariant by mutableStateOf(brandVariant)
        private set
    var variation by mutableStateOf(variation)
        private set
    var bg by mutableStateOf(bg)
        private set
    var bgVariant by mutableStateOf(bgVariant)
        private set
    var errorBg by mutableStateOf(errorBg)
        private set
    var onBrand by mutableStateOf(onBrand)
        private set
    var onBrandVariant by mutableStateOf(onBrandVariant)
        private set
    var onBg by mutableStateOf(onBg)
        private set
    var onBgVariant by mutableStateOf(onBgVariant)
        private set
    var onErrorBg by mutableStateOf(onErrorBg)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: ColorsMainTheme) {
        brand = other.brand
        brandVariant = other.brandVariant
        variation = other.variation
        bg = other.bg
        bgVariant = other.bgVariant
        errorBg = other.errorBg
        onBrand = other.onBrand
        onBrandVariant = other.onBrandVariant
        onBg = other.onBg
        onBgVariant = other.onBgVariant
        onErrorBg = other.onErrorBg
        isDark = other.isDark
    }

    fun copy(): ColorsMainTheme = ColorsMainTheme(
        brand = brand,
        brandVariant = brandVariant,
        variation = variation,
        bg = bg,
        bgVariant = bgVariant,
        errorBg = errorBg,
        onBrand = onBrand,
        onBrandVariant = onBrandVariant,
        onBg = onBg,
        onBgVariant = onBgVariant,
        onErrorBg = onErrorBg,
        isDark = isDark,
    )
}