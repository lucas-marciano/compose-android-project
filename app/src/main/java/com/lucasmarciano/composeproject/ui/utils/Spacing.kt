package com.lucasmarciano.composeproject.ui.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val extraMedium: Dp = 24.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 40.dp,
    val huge: Dp = 60.dp,
    val extraHuge: Dp = 80.dp,
    val giga: Dp = 100.dp,

    val defaultPadding: Dp = 10.dp,

    val smallIcon: Dp = 28.dp,
    val largeIcon: Dp = 40.dp,

    val cardWidth: Dp = 150.dp,
    val cardHeight: Dp = 200.dp,
    val toolbarHeight: Dp = 56.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current
