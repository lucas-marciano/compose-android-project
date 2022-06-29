package com.lucasmarciano.iti_module.typo

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.lucasmarciano.iti_module.R

internal val nunitoFont = FontFamily(
    Font(R.font.nunito),
    Font(R.font.nunito, weight = FontWeight.Bold),
    Font(R.font.nunito, weight = FontWeight.Light),
    Font(R.font.nunito, weight = FontWeight.Thin),
    Font(R.font.nunito_italic, style = FontStyle.Italic),
)

internal val roboto = FontFamily(
    Font(R.font.roboto_regular),
    Font(R.font.roboto_italic, style = FontStyle.Italic),
    Font(R.font.roboto_black, weight = FontWeight.Black),
    Font(R.font.roboto_black_italic, weight = FontWeight.Black, style = FontStyle.Italic),
    Font(R.font.roboto_bold, weight = FontWeight.Bold),
    Font(R.font.roboto_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.roboto_light, weight = FontWeight.Light),
    Font(R.font.roboto_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.roboto_medium, weight = FontWeight.Medium),
    Font(R.font.roboto_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.roboto_thin, weight = FontWeight.Thin),
    Font(R.font.roboto_thin_italic, weight = FontWeight.Thin, style = FontStyle.Italic),
)