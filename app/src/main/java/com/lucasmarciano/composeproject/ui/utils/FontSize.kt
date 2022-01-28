package com.lucasmarciano.composeproject.ui.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class FontSize(
    val small: TextUnit = 14.sp,
    val medium: TextUnit = 16.sp,
    val large: TextUnit = 20.sp,
    val extraLarge: TextUnit = 26.sp,
    val lineSpaceDefault: TextUnit = 0.5.sp,
)

val LocalFontSize = compositionLocalOf { FontSize() }

val MaterialTheme.fontSize: FontSize
    @Composable
    @ReadOnlyComposable
    get() = LocalFontSize.current
