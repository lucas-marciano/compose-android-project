package com.lucasmarciano.composeproject.ui.components.shimmer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer.ShimmerView
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer.brushColors
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
fun ShimmerLayout(isLoading: Boolean = true, content: @Composable () -> Unit) {
    ShimmerView(isLoading, content) { HomeShimmerScreen(brush = it) }
}

@Composable
private fun HomeShimmerScreen(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.medium,
                end = MaterialTheme.spacing.medium
            )
    ) {
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.huge))
        AvatarShimmer(brush = brush)
        TitleShimmer(brush = brush)
        BlueCardShimmer(brush = brush)
        SubTitleShimmer(brush = brush)
        CardWithIconShimmer(brush = brush)
        SubTitleShimmer(brush = brush)
        BannerShimmer(brush = brush)
    }
}

@Preview
@Composable
private fun HomeShimmerScreenPreview() {
    HomeShimmerScreen(brushColors)
}