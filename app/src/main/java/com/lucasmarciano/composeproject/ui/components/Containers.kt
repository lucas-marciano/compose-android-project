package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
fun MainContainer(content: @Composable () -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.medium,
                end = MaterialTheme.spacing.medium
            )
            .verticalScroll(scrollState)
    ) {
        content()
    }
}