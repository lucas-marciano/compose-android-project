package com.lucasmarciano.composeproject.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.lucasmarciano.composeproject.ui.theme.ColorBlueCard
import com.lucasmarciano.composeproject.ui.theme.ColorPinkCalifornia
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.values.ColorComponent
import com.lucasmarciano.composeproject.ui.values.TypeToolbar

@Composable
fun getBgToolbarColor(typeToolbar: TypeToolbar) = when (typeToolbar) {
    TypeToolbar.NORMAL -> ComposeProjectTheme.colors.brand
    TypeToolbar.BLUE -> ColorBlueCard
}

@Composable
fun getColorToolbarTitle(type: TypeToolbar) = when (type) {
    TypeToolbar.BLUE -> Color.White
    TypeToolbar.NORMAL -> ComposeProjectTheme.colors.onBg
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
        ColorComponent.BACKGROUND -> ComposeProjectTheme.colors.bg
        ColorComponent.SECONDARY -> ComposeProjectTheme.colors.brandVariant
        ColorComponent.SURFACE -> ComposeProjectTheme.colors.bgVariant
        ColorComponent.ON_PRIMARY -> ComposeProjectTheme.colors.onBrand
        ColorComponent.ON_SECONDARY -> ComposeProjectTheme.colors.onBrandVariant
        ColorComponent.ON_BACKGROUND -> ComposeProjectTheme.colors.onBg
        ColorComponent.ON_SURFACE -> ComposeProjectTheme.colors.onBrandVariant
        else -> ComposeProjectTheme.colors.brand
    }
}

@Composable
fun getDimensionValue(dimen: Int) = LocalDensity.current.run { dimen.toDp() }
