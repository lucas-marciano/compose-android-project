package com.lucasmarciano.iti_module.typo

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.lucasmarciano.core.theme.IType

data class Type(
    override val body1: TextStyle = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = FontSize().medium,
        textAlign = TextAlign.Start
    ),
    override val body2: TextStyle = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Thin,
        fontSize = FontSize().small,
        textAlign = TextAlign.Start
    ),
    override val subtitle1: TextStyle = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        fontSize = FontSize().large,
        letterSpacing = FontSize().letterSpacingDefault,
        textAlign = TextAlign.Start
    ),
    override val subtitle2: TextStyle = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        fontSize = FontSize().small,
        textAlign = TextAlign.Center
    ),
    override val h1: TextStyle = TextStyle(
        fontFamily = roboto,
        fontSize = FontSize().midLarge,
        letterSpacing = FontSize().letterSpacingDefault,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
    ),
    override val h2: TextStyle = TextStyle(
        fontFamily = roboto,
        fontSize = FontSize().large,
        letterSpacing = FontSize().letterSpacingDefault,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
    ),
    override val button: TextStyle = TextStyle(
        fontFamily = roboto,
        fontSize = FontSize().minimum,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
    )
) : IType

val LocalLibType = compositionLocalOf { Type() }