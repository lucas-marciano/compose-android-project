package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.theme.PinkCalifornia


@Composable
fun LoadingBarScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = PinkCalifornia
        )
    }
}

@Composable
fun LoadingBar() {
    CircularProgressIndicator(
        color = PinkCalifornia
    )
}

@Preview(showBackground = true)
@Composable
fun LoadingBarScreenPreview() {
    ComposeProjectTheme {
        LoadingBarScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingBarPreview() {
    ComposeProjectTheme {
        LoadingBar()
    }
}
