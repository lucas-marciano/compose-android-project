package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.theme.ColorPinkCalifornia

@Composable
fun ContainerCircleLoading(isLoading: Boolean = true, content: @Composable () -> Unit) {
    LoadingBarScreen(isLoading)
    if (isLoading.not()) content()
}

@Composable
private fun LoadingBarScreen(isLoading: Boolean = true) {
    if (isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                color = ColorPinkCalifornia
            )
        }
    }
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
fun ContainerCircleLoadingPreview() {
    ComposeProjectTheme {
        ContainerCircleLoading(isLoading = true) {
            Text(text = "test")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContainerCircleLoadingIsLoadingFalsePreview() {
    ComposeProjectTheme {
        ContainerCircleLoading(isLoading = false) {
            Text(text = "test")
        }
    }
}

