package com.lucasmarciano.iti_theme.dimens

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lucasmarciano.core.theme.IElevation

data class Elevation(
    override val extraSmall: Dp = 4.dp,
    override val small: Dp = 8.dp,
    override val medium: Dp = 16.dp,
    override val noElevation: Dp = 0.dp
) : IElevation

val LocalLibElevation = compositionLocalOf { Elevation() }
