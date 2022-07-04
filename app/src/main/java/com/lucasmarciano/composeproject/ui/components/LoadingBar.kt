package com.lucasmarciano.composeproject.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.core.utils.ComposableAliasSimple
import com.lucasmarciano.iti_module.ItiTheme
import com.lucasmarciano.iti_module.colors.ColorPinkCalifornia

@Composable
fun ContainerCircleLoading(isLoading: Boolean = true, content: ComposableAliasSimple) {
    val currentPage by remember { mutableStateOf(isLoading) }
    Crossfade(targetState = currentPage) { screen ->
        when (screen) {
            true -> LoadingBarScreen()
            else -> content()
        }
    }
}

@Composable
private fun LoadingBarScreen() {
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

@Preview(showBackground = true)
@Composable
fun ContainerCircleLoadingPreview() {
    ItiTheme {
        ContainerCircleLoading(isLoading = true) {
            Text(text = "test")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContainerCircleLoadingIsLoadingFalsePreview() {
    ItiTheme {
        ContainerCircleLoading(isLoading = false) {
            Text(text = "test")
        }
    }
}

