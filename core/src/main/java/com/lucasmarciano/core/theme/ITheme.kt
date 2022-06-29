package com.lucasmarciano.core.theme

import androidx.compose.runtime.Composable

interface ITheme {
    val colors: IColor
        @Composable get
    val spacing: ISpacing
        @Composable get
    val elevation: IElevation
        @Composable get
    val fontSize: IFontSize
        @Composable get
    val type: IType
        @Composable get
    val shapes: IShape
        @Composable get
}
