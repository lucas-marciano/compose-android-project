package com.lucasmarciano.composeproject.ui.components.shimmer

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer.brushColors
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
fun AvatarShimmer(brush: Brush) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = MaterialTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .size(MaterialTheme.spacing.extraHuge)
                .clip(CircleShape)
                .background(brush = brush)
        )
    }
}

@Preview(name = "Avatar", showBackground = true)
@Composable
fun AvatarShimmerPreview() {
    AvatarShimmer(brush = brushColors)
}

@Preview(name = "Avatar Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AvatarShimmerDarkPreview() {
    AvatarShimmer(brush = brushColors)
}