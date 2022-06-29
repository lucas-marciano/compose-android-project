package com.lucasmarciano.core.theme

import androidx.compose.ui.unit.TextUnit

interface IFontSize {
    val minimum: TextUnit
    val small: TextUnit
    val medium: TextUnit
    val large: TextUnit
    val midLarge: TextUnit
    val extraLarge: TextUnit
    val lineSpaceDefault: TextUnit
    val letterSpacingDefault: TextUnit
}
