package com.lucasmarciano.composeproject.ui.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.lucasmarciano.composeproject.ui.theme.ColorBlueCard
import com.lucasmarciano.composeproject.ui.theme.ColorPinkCalifornia
import com.lucasmarciano.composeproject.ui.values.ColorComponent
import com.lucasmarciano.composeproject.ui.values.TypeToolbar

@Composable
fun getBgToolbarColor(typeToolbar: TypeToolbar) = when (typeToolbar) {
    TypeToolbar.NORMAL -> MaterialTheme.colors.primary
    TypeToolbar.BLUE -> ColorBlueCard
}

@Composable
fun getColorToolbarTitle(type: TypeToolbar) = when (type) {
    TypeToolbar.BLUE -> Color.White
    TypeToolbar.NORMAL -> MaterialTheme.colors.onBackground
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
        ColorComponent.BACKGROUND -> MaterialTheme.colors.background
        ColorComponent.SECONDARY -> MaterialTheme.colors.secondary
        ColorComponent.SURFACE -> MaterialTheme.colors.surface
        ColorComponent.ON_PRIMARY -> MaterialTheme.colors.onPrimary
        ColorComponent.ON_SECONDARY -> MaterialTheme.colors.onSecondary
        ColorComponent.ON_BACKGROUND -> MaterialTheme.colors.onBackground
        ColorComponent.ON_SURFACE -> MaterialTheme.colors.onSurface
        else -> MaterialTheme.colors.primary
    }
}

@Composable
fun getDimensionValue(dimen: Int) = LocalDensity.current.run { dimen.toDp() }
