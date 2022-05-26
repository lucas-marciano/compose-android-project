package com.lucasmarciano.composeproject.features.home.components

import android.content.res.Configuration
import androidx.compose.foundation.background
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
import com.lucasmarciano.composeproject.utils.ComposableAlias
import com.lucasmarciano.composeproject.ui.components.shimmer.BannerShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.BlueCardShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.CardWithIconShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.CircleShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer.ShimmerView
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer.brushColors
import com.lucasmarciano.composeproject.ui.components.shimmer.SubTitleShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.TitleShimmer
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
fun ShimmerHomeController(isLoading: Boolean = true, content: ComposableAlias) {
    ShimmerView(isLoading, content) { HomeShimmerScreen(brush = it) }
}

@Composable
private fun HomeShimmerScreen(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(
                top = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.medium,
                end = MaterialTheme.spacing.medium
            )
    ) {
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.huge))
        CircleShimmer(brush = brush)
        TitleShimmer(brush = brush)
        BlueCardShimmer(brush = brush)
        SubTitleShimmer(brush = brush)
        CardWithIconShimmer(brush = brush)
        SubTitleShimmer(brush = brush)
        BannerShimmer(brush = brush)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeShimmerScreenPreview() {
    HomeShimmerScreen(brushColors)
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun HomeShimmerScreenDarkPreview() {
    HomeShimmerScreen(brushColors)
}
