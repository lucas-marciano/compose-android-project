package com.lucasmarciano.iti_theme

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ComponentTest() {
    Text(
        text = "test",
        style = ItiTheme.type.body1,
        fontSize = ItiTheme.fontSize.extraLarge,
        color = ItiTheme.colors.variation
    )
}

@Preview
@Composable
private fun Preview() {
    ComponentTest()
}