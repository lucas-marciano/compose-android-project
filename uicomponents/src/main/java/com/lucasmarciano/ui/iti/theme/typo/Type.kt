package com.lucasmarciano.ui.iti.theme.typo

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

data class Type(
    val body1: TextStyle = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = FontSize().medium,
        textAlign = TextAlign.Start
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Thin,
        fontSize = FontSize().minimum,
        textAlign = TextAlign.Start
    ),
    val subtitle1: TextStyle = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        fontSize = FontSize().large,
        letterSpacing = FontSize().letterSpacingDefault,
        textAlign = TextAlign.Start
    ),
    val subtitle2: TextStyle = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        fontSize = FontSize().small,
        textAlign = TextAlign.Center
    ),
    val h1: TextStyle = TextStyle(
        fontFamily = roboto,
        fontSize = FontSize().midLarge,
        letterSpacing = FontSize().letterSpacingDefault,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = roboto,
        fontSize = FontSize().large,
        letterSpacing = FontSize().letterSpacingDefault,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
    ),
    val button: TextStyle = TextStyle(
        fontFamily = roboto,
        fontSize = FontSize().minimum,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
    )
)

val LocalLibType = compositionLocalOf { Type() }