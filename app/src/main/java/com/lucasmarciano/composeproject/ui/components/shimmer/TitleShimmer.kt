package com.lucasmarciano.composeproject.ui.components.shimmer

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer.brushColors
import com.lucasmarciano.iti_module.ItiTheme

@Composable
fun TitleShimmer(brush: Brush, widthFraction: Float = 1f) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = ItiTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .height(ItiTheme.spacing.extraMedium)
                .clip(RoundedCornerShape(ItiTheme.spacing.small))
                .fillMaxWidth(fraction = widthFraction)
                .background(brush = brush)
        )
    }
}

@Composable
fun SubTitleShimmer(brush: Brush) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = ItiTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(ItiTheme.spacing.medium)
                .clip(RoundedCornerShape(ItiTheme.spacing.small))
                .fillMaxWidth(fraction = 0.9f)
                .background(brush = brush)
        )
    }
}

@Preview(name = "Title", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun TitleShimmerPreview() {
    TitleShimmer(brush = brushColors)
}

@Preview(name = "Sub Title", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun SubTitleShimmerPreview() {
    SubTitleShimmer(brush = brushColors)
}

@Preview(name = "Title Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TitleShimmerDarkPreview() {
    TitleShimmer(brush = brushColors)
}

@Preview(name = "Sub Title Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SubTitleShimmerDarkPreview() {
    SubTitleShimmer(brush = brushColors)
}
