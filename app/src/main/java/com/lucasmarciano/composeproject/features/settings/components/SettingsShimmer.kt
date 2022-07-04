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
import com.lucasmarciano.core.utils.ComposableAliasSimple
import com.lucasmarciano.iti_module.ItiTheme

@Composable
fun ShimmerSettingsController(isLoading: Boolean = true, content: ComposableAliasSimple) {
    ShimmerView(isLoading, content) { SettingsShimmerScreen(brush = it) }
}

@Composable
fun SettingsShimmerScreen(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ItiTheme.colors.bg)
            .padding(
                top = ItiTheme.spacing.medium,
                start = ItiTheme.spacing.medium,
                end = ItiTheme.spacing.medium
            )
    ) {
        Spacer(modifier = Modifier.height(ItiTheme.spacing.huge))
        CircleShimmer(brush = brush)
        Spacer(modifier = Modifier.height(ItiTheme.spacing.extraMedium))
        SubTitleShimmer(brush = brush)
        SubTitleShimmer(brush = brush)
        Spacer(modifier = Modifier.height(ItiTheme.spacing.extraMedium))
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
