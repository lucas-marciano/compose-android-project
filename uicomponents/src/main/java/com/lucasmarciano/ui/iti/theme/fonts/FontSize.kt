package com.lucasmarciano.ui.iti.theme.fonts

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class FontSize(
    val minimum: TextUnit = 13.sp,
    val small: TextUnit = 14.sp,
    val medium: TextUnit = 16.sp,
    val large: TextUnit = 20.sp,
    val midLarge: TextUnit = 24.sp,
    val extraLarge: TextUnit = 26.sp,
    val lineSpaceDefault: TextUnit = 0.5.sp,
    val letterSpacingDefault: TextUnit = 0.5.sp,
)

val LibFontSize = compositionLocalOf { FontSize() }
