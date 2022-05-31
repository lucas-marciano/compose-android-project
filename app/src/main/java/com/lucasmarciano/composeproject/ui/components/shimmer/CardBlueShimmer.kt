package com.lucasmarciano.composeproject.ui.components.shimmer

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
fun BlueCardShimmer(brush: Brush) {
    Row(
        modifier = Modifier
            .padding(all = ComposeProjectTheme.spacing.small)
            .fillMaxWidth()
    ) {
        repeat(3) {
            Row {
                Box(
                    modifier = Modifier
                        .height(ComposeProjectTheme.spacing.cardHeight)
                        .width(ComposeProjectTheme.spacing.cardWidth)
                        .clip(RoundedCornerShape(ComposeProjectTheme.spacing.small))
                        .background(brush)
                )
                Spacer(modifier = Modifier.width(ComposeProjectTheme.spacing.medium))
            }
        }
    }
}

@Preview(name = "Card Blue", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun CardBlueShimmerPreview() {
    BlueCardShimmer(brush = MainAnimatedShimmer.brushColors)
}

@Preview(
    name = "Card Blue Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun CardBlueShimmerDarkPreview() {
    BlueCardShimmer(brush = MainAnimatedShimmer.brushColors)
}