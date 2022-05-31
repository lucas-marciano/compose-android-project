package com.lucasmarciano.composeproject.ui.components.shimmer

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
fun MenuItemShimmer(brush: Brush) {
    Row(
        modifier = Modifier.padding(bottom = ComposeProjectTheme.spacing.extraSmall),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleShimmer(brush = brush, size = ComposeProjectTheme.spacing.extraLarge)
        SubTitleShimmer(brush = brush)
    }
}

@Preview(name="Menu Item", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun MenuItemShimmerPreview() {
    MenuItemShimmer(brush = MainAnimatedShimmer.brushColors)
}

@Preview(name = "Menu Item Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MenuItemShimmerDarkPreview() {
    MenuItemShimmer(brush = MainAnimatedShimmer.brushColors)
}
