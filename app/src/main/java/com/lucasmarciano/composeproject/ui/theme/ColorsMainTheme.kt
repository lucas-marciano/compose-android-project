package com.lucasmarciano.composeproject.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val ColorPrimary = Color(0xFFFFFBFE)
val ColorPrimaryVariant = Color(0xFFFFFBFE)
val ColorSecondary = Color(0xFFFFFBFE)
val ColorBackground = Color(0xFFFFFBFE)
val ColorSurface = Color(0xFFE8E2E6)
val ColorError = Color(0xFFF44336)
val ColorOnPrimary = Color(0xFF1C1B1F)
val ColorOnSecondary = Color(0xFF1C1B1F)
val ColorOnBackground = Color(0xFF1C1B1F)
val ColorOnSurface = Color(0x401C1B1F)
val ColorOnError = Color(0x401C1B1F)

val ColorDarkPrimary = Color(0xFF1C1B1F)
val ColorDarkPrimaryVariant = Color(0xFF444444)
val ColorDarkSecondary = Color(0xFF1C1B1F)
val ColorDarkBackground = Color(0xFF1C1B1F)
val ColorDarkSurface = Color(0xFF1C1B1F)
val ColorDarkError = Color(0xFFF44336)
val ColorDarkOnPrimary = Color(0xFFFFFBFE)
val ColorDarkOnSecondary = Color(0xFFFFFBFE)
val ColorDarkOnBackground = Color(0xFFFFFBFE)
val ColorDarkOnSurface = Color(0xFFFFFBFE)
val ColorDarkOnError = Color(0xFFFFFFFF)

val ColorPinkCalifornia = Color(0xFFFF4B8D)
val ColorPinkCaliforniaVariant = Color(0xFFc60055)
val ColorBlueCard = Color(0xFF106FF4)
val ColorBlueChipInfo = Color(0xFFE6E6FF)
val ColorRedChipInfo = Color(0xFFE9ADAD)
val ColorSalesToolbar = Color(0xFF106FF4)

internal val DarkColorPalette = ColorsMainTheme(
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

internal val LightColorPalette = ColorsMainTheme(
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
