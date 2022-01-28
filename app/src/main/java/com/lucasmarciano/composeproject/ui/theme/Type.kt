package com.lucasmarciano.composeproject.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val Typography = Typography(
    subtitle1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Start
    ),
    h1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
    ),
    h2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )
)