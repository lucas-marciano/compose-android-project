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
import com.lucasmarciano.ui.iti.theme.ItiTheme

@Composable
fun HeaderItem(modifier: Modifier = Modifier, title: String, info: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(ItiTheme.colors.bgVariant)
            .height(ItiTheme.spacing.extraLarge)
            .padding(horizontal = ItiTheme.spacing.extraLarge),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, color = ItiTheme.colors.onBrand)
        Text(text = info, fontWeight = FontWeight.Bold, color = ItiTheme.colors.onBrand)
    }
}

@Preview
@Composable
private fun HeaderItemPreview() {
    ItiTheme {
        HeaderItem(title = "title", info = "info")
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HeaderItemDarkPreview() {
    ItiTheme {
        HeaderItem(title = "title", info = "info")
    }
}
