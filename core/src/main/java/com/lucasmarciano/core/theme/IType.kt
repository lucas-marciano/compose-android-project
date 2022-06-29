package com.lucasmarciano.core.theme

import androidx.compose.ui.text.TextStyle

sealed interface IType {
    val body1: TextStyle
    val body2: TextStyle
    val subtitle1: TextStyle
    val subtitle2: TextStyle
    val h1: TextStyle
    val h2: TextStyle
    val button: TextStyle
}
