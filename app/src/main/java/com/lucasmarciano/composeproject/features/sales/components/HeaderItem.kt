package com.lucasmarciano.composeproject.features.sales.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
fun HeaderItem(modifier: Modifier = Modifier, title: String, info: String) {
    Row(
        modifier = modifier
            .background(ComposeProjectTheme.colors.brandVariant)
            .fillMaxWidth()
            .height(ComposeProjectTheme.spacing.extraLarge)
            .padding(horizontal = ComposeProjectTheme.spacing.extraLarge),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, color = ComposeProjectTheme.colors.onBrand)
        Text(text = info, fontWeight = FontWeight.Bold, color = ComposeProjectTheme.colors.onBrand)
    }
}

@Preview
@Composable
private fun HeaderItemPreview() {
    ComposeProjectTheme {
        HeaderItem(title = "title", info = "info")
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HeaderItemDarkPreview() {
    ComposeProjectTheme {
        HeaderItem(title = "title", info = "info")
    }
}
