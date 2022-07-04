package com.lucasmarciano.iti_theme.typo

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.lucasmarciano.core.theme.IFontSize

data class FontSize(
    override val minimum: TextUnit = 13.sp,
    override val small: TextUnit = 14.sp,
    override val medium: TextUnit = 16.sp,
    override val large: TextUnit = 20.sp,
    override val midLarge: TextUnit = 24.sp,
    override val extraLarge: TextUnit = 26.sp,
    override val lineSpaceDefault: TextUnit = 0.5.sp,
    override val letterSpacingDefault: TextUnit = 0.5.sp,
) : IFontSize

val LocalLibFontSize = compositionLocalOf { FontSize() }
