package com.lucasmarciano.composeproject.ui.components.shimmer

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.lucasmarciano.iti_theme.ItiTheme

@Composable
fun ItemTimeLineShimmer(brush: Brush) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(ItiTheme.colors.bg)
    ) {

        val (line, icon, content, tag) = createRefs()

        Box(
            modifier = Modifier
                .width(1.dp)
                .background(brush)
                .constrainAs(line) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(icon.start)
                    end.linkTo(icon.end)
                    height = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .padding(ItiTheme.spacing.small)
                .height(ItiTheme.spacing.medium)
                .width(ItiTheme.spacing.medium)
                .clip(CircleShape)
                .background(brush)
                .constrainAs(icon) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start, margin = 25.dp)
                }
        )

        Column(
            modifier = Modifier.constrainAs(content) {
                top.linkTo(parent.top, margin = 24.dp)
                bottom.linkTo(parent.bottom, margin = 24.dp)
                start.linkTo(line.start, margin = 24.dp)
            }
        ) {
            Box(
                modifier = Modifier
                    .height(ItiTheme.spacing.medium)
                    .width(150.dp)
                    .clip(RoundedCornerShape(ItiTheme.spacing.extraMedium))
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .height(ItiTheme.spacing.large)
                    .width(100.dp)
                    .clip(RoundedCornerShape(ItiTheme.spacing.extraMedium))
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(ItiTheme.spacing.extraSmall))
            Box(
                modifier = Modifier
                    .height(ItiTheme.spacing.medium)
                    .width(50.dp)
                    .clip(RoundedCornerShape(ItiTheme.spacing.extraMedium))
                    .background(brush)
            )
        }
        Box(modifier = Modifier
            .height(ItiTheme.spacing.medium)
            .width(ItiTheme.spacing.large)
            .clip(CircleShape)
            .background(brush)
            .constrainAs(tag) {
                top.linkTo(parent.top, margin = 20.dp)
                end.linkTo(parent.end, margin = 24.dp)
            })
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ItemTimeLineShimmerPreview() {
    ItiTheme {
        ItemTimeLineShimmer(brush = MainAnimatedShimmer.brushColors)
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ItemTimeLineShimmerDarkPreview() {
    ItiTheme {
        ItemTimeLineShimmer(brush = MainAnimatedShimmer.brushColors)
    }
}
