package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.data.home.models.BannerVO
import com.lucasmarciano.composeproject.ui.mockspreview.mockBanner
import com.lucasmarciano.composeproject.ui.theme.ColorPinkCalifornia
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.elevation
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
internal fun Banner(banner: BannerVO?) {
    banner?.let { item ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { }),
            shape = RoundedCornerShape(MaterialTheme.spacing.small),
            elevation = MaterialTheme.elevation.extraSmall,
            backgroundColor = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.defaultPadding),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = item.description,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body2,
                )
                Spacer(modifier = Modifier.height(height = MaterialTheme.spacing.extraMedium))
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.callToAction.name,
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(end = MaterialTheme.spacing.extraSmall)
                    )
                    Icon(
                        Icons.Filled.ChevronRight,
                        item.callToAction.name,
                        tint = ColorPinkCalifornia,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun BannerPreview() {
    ComposeProjectTheme {
        Banner(mockBanner())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BannerDarkPreview() {
    ComposeProjectTheme {
        Banner(mockBanner())
    }
}
