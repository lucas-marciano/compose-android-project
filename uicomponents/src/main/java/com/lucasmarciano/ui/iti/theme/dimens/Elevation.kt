package com.lucasmarciano.ui.iti.theme.dimens

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Elevation(
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val noElevation: Dp = 0.dp
)

val LibElevation = compositionLocalOf { Elevation() }
