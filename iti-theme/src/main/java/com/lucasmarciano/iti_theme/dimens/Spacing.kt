package com.lucasmarciano.iti_theme.dimens

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lucasmarciano.core.theme.ISpacing

data class Spacing(
    override val extraSmall: Dp = 4.dp,
    override val small: Dp = 8.dp,
    override val medium: Dp = 16.dp,
    override val extraMedium: Dp = 24.dp,
    override val large: Dp = 32.dp,
    override val extraLarge: Dp = 40.dp,
    override val huge: Dp = 60.dp,
    override val extraHuge: Dp = 80.dp,
    override val giga: Dp = 100.dp,
    override val defaultPadding: Dp = 10.dp,
    override val smallIcon: Dp = 28.dp,
    override val largeIcon: Dp = 40.dp,
    override val cardWidth: Dp = 150.dp,
    override val cardHeight: Dp = 200.dp,
    override val toolbarHeight: Dp = 56.dp,
    override val borderMinimum: Dp = 1.dp,
    override val border: Dp = 2.dp,
) : ISpacing

val LocalLibSpacing = compositionLocalOf { Spacing() }
