package com.lucasmarciano.ui.iti.theme.typo

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.lucasmarciano.ui.iti.R

internal val nunitoFont = FontFamily(
    Font(R.font.nunito),
    Font(R.font.nunito, weight = FontWeight.Bold),
    Font(R.font.nunito, weight = FontWeight.Light),
    Font(R.font.nunito, weight = FontWeight.Thin),
    Font(R.font.nunito_italic, style = FontStyle.Italic),
)