package com.lucasmarciano.composeproject.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.lucasmarciano.composeproject.ui.values.ColorComponent
import com.lucasmarciano.composeproject.ui.values.TypeToolbar
import com.lucasmarciano.iti_module.ItiTheme
import com.lucasmarciano.iti_module.colors.ColorBlueCard
import com.lucasmarciano.iti_module.colors.ColorPinkCalifornia

@Composable
fun getBgToolbarColor(typeToolbar: TypeToolbar) = when (typeToolbar) {
    TypeToolbar.NORMAL -> ItiTheme.colors.brand
    TypeToolbar.BLUE -> ColorBlueCard
}

@Composable
fun getColorToolbarTitle(type: TypeToolbar) = when (type) {
    TypeToolbar.BLUE -> Color.White
    TypeToolbar.NORMAL -> ItiTheme.colors.onBg
}

@Composable
fun getColorToolbarIcons(type: TypeToolbar) = when (type) {
    TypeToolbar.BLUE -> Color.White
    TypeToolbar.NORMAL -> ColorPinkCalifornia
}

@Composable
fun getColorValue(colorComponent: ColorComponent): Color {
    return when (colorComponent) {
        ColorComponent.PINK -> ColorPinkCalifornia
        ColorComponent.BLUE_CARD_BG -> ColorBlueCard
        ColorComponent.BACKGROUND -> ItiTheme.colors.bg
        ColorComponent.SECONDARY -> ItiTheme.colors.brandVariant
        ColorComponent.SURFACE -> ItiTheme.colors.bgVariant
        ColorComponent.ON_PRIMARY -> ItiTheme.colors.onBrand
        ColorComponent.ON_SECONDARY -> ItiTheme.colors.onBrandVariant
        ColorComponent.ON_BACKGROUND -> ItiTheme.colors.onBg
        ColorComponent.ON_SURFACE -> ItiTheme.colors.onBrandVariant
        else -> ItiTheme.colors.brand
    }
}

@Composable
fun getDimensionValue(dimen: Int) = LocalDensity.current.run { dimen.toDp() }
