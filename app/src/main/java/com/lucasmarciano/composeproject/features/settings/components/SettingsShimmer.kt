package com.lucasmarciano.composeproject.features.settings.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.components.shimmer.CircleShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer.ShimmerView
import com.lucasmarciano.composeproject.ui.components.shimmer.MenuItemShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.SubTitleShimmer
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.utils.ComposableAlias

@Composable
fun ShimmerSettingsController(isLoading: Boolean = true, content: ComposableAlias) {
    ShimmerView(isLoading, content) { SettingsShimmerScreen(brush = it) }
}

@Composable
fun SettingsShimmerScreen(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ComposeProjectTheme.colors.bg)
            .padding(
                top = ComposeProjectTheme.spacing.medium,
                start = ComposeProjectTheme.spacing.medium,
                end = ComposeProjectTheme.spacing.medium
            )
    ) {
        Spacer(modifier = Modifier.height(ComposeProjectTheme.spacing.huge))
        CircleShimmer(brush = brush)
        Spacer(modifier = Modifier.height(ComposeProjectTheme.spacing.extraMedium))
        SubTitleShimmer(brush = brush)
        SubTitleShimmer(brush = brush)
        Spacer(modifier = Modifier.height(ComposeProjectTheme.spacing.extraMedium))
        repeat(4) {
            MenuItemShimmer(brush = brush)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun SettingsShimmerScreenPreview() {
    SettingsShimmerScreen(MainAnimatedShimmer.brushColors)
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun SettingsShimmerScreenDarkPreview() {
    SettingsShimmerScreen(MainAnimatedShimmer.brushColors)
}
