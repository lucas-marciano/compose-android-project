package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme


@Composable
fun LoadingBarScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun LoadingBar() {
    Column {

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
fun LoadingBarPreview() {
    ComposeProjectTheme {
        LoadingBar()
    }
}
