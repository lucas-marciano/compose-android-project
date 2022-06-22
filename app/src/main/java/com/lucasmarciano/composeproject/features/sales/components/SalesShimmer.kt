package com.lucasmarciano.composeproject.features.sales.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasmarciano.composeproject.ui.components.shimmer.ItemTimeLineShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer.ShimmerView
import com.lucasmarciano.composeproject.ui.components.shimmer.TitleShimmer
import com.lucasmarciano.composeproject.ui.theme.ColorSalesToolbar
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.utils.ComposableAliasSimple

@Composable
fun ShimmerSalesHeaderController(isLoading: Boolean = true, content: ComposableAliasSimple) {
    ShimmerView(isLoading, content) { SalesShimmerHeaderScreen(brush = it) }
}

@Composable
fun ShimmerSalesTimeListController(isLoading: Boolean = true, content: ComposableAliasSimple) {
    ShimmerView(isLoading, content) { SalesShimmerListScreen(brush = it) }
}

@Composable
private fun SalesShimmerHeaderScreen(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ComposeProjectTheme.colors.bg)
    ) {
        Column {
            Column(
                modifier = Modifier
                    .background(ColorSalesToolbar)
                    .padding(all = 24.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(ComposeProjectTheme.spacing.giga))

                TitleShimmer(brush = brush, 0.4f)

                TitleShimmer(brush = brush, 0.6f)

                TitleShimmer(brush = brush, 0.5f)
            }
        }
    }
}

@Composable
private fun SalesShimmerListScreen(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ComposeProjectTheme.colors.bg)
    ) {
        Surface(
            elevation = 4.dp, modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ComposeProjectTheme.colors.bg),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .width(130.dp)
                        .clip(RoundedCornerShape(ComposeProjectTheme.spacing.small))
                        .background(brush)
                )
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .width(130.dp)
                        .clip(RoundedCornerShape(ComposeProjectTheme.spacing.small))
                        .background(brush)
                )
            }
        }
        repeat(7) {
            ItemTimeLineShimmer(brush = brush)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SalesShimmerTopScreenPreview() {
    ComposeProjectTheme {
        SalesShimmerHeaderScreen(MainAnimatedShimmer.brushColors)
    }
}

@Preview(showBackground = true)
@Composable
private fun SalesShimmerListScreenPreview() {
    ComposeProjectTheme {
        SalesShimmerListScreen(MainAnimatedShimmer.brushColors)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun SalesShimmerTopScreenDarkPreview() {
    ComposeProjectTheme {
        SalesShimmerHeaderScreen(MainAnimatedShimmer.brushColors)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun SalesShimmerListScreenDarkPreview() {
    ComposeProjectTheme {
        SalesShimmerListScreen(MainAnimatedShimmer.brushColors)
    }
}