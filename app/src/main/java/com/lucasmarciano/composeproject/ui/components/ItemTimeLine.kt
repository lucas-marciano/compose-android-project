package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.lucasmarciano.composeproject.data.models.ItemTimeLineVO
import com.lucasmarciano.composeproject.ui.components.shimmer.ItemTimeLineShimmer
import com.lucasmarciano.composeproject.ui.components.shimmer.MainAnimatedShimmer.ShimmerView
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemTimeLine
import com.lucasmarciano.iti_module.ItiTheme

@Composable
internal fun ItemTimeLine(
    item: ItemTimeLineVO,
    isLoading: Boolean = false,
    onClick: (String) -> Unit = { },
) {
    ShimmerView(
        isLoading,
        { ItemTimeLineContainer(item, onClick) }) { ItemTimeLineShimmer(brush = it) }
}

@Composable
internal fun ItemTimeLineContainer(item: ItemTimeLineVO, onClick: (String) -> Unit = { }) {
    ConstraintLayout(
        modifier = Modifier
            .clickable { onClick(item.callToActionVO.action) }
            .fillMaxWidth()
            .background(ItiTheme.colors.bg)
    ) {

        val (line, icon, content, tag) = createRefs()

        Divider(
            modifier = Modifier
                .width(1.dp)
                .background(ItiTheme.colors.onBg)
                .constrainAs(line) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(icon.start)
                    end.linkTo(icon.end)
                    height = Dimension.fillToConstraints
                }
        )

        Icon(
            imageVector = Icons.Default.LockClock,
            contentDescription = "",
            tint = ItiTheme.colors.onBg,
            modifier = Modifier
                .padding(4.dp)
                .background(color = ItiTheme.colors.bg)
                .constrainAs(icon) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start, margin = 25.dp)
                }
        )

        Column(
            modifier = Modifier
                .constrainAs(content) {
                    top.linkTo(parent.top, margin = 24.dp)
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    start.linkTo(line.start, margin = 24.dp)
                },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.title,
                style = ItiTheme.type.subtitle1,
                color = ItiTheme.colors.onBgVariant,
                maxLines = 1
            )
            Text(
                text = item.value,
                color = ItiTheme.colors.onBg,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
            Text(
                text = item.description,
                style = ItiTheme.type.subtitle2,
                color = ItiTheme.colors.onBgVariant,
                maxLines = 1
            )
        }
        if (item.tag.isNotEmpty())
            Box(modifier = Modifier.constrainAs(tag) {
                top.linkTo(parent.top, margin = 20.dp)
                end.linkTo(parent.end, margin = 24.dp)
            }) {
                Chip(item.tag, item.tagType)
            }
    }
}

@Preview
@Composable
private fun ItemTimeLineShimmerOnPreview() {
    ItiTheme {
        ItemTimeLine(mockItemTimeLine(), true)
    }
}

@Preview
@Composable
private fun ItemTimeLineShimmerOffPreview() {
    ItiTheme {
        ItemTimeLine(mockItemTimeLine(), false)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ItemTimeLineShimmerOnDarkPreview() {
    ItiTheme {
        ItemTimeLine(mockItemTimeLine(), true)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ItemTimeLineShimmerOffDarkPreview() {
    ItiTheme {
        ItemTimeLine(mockItemTimeLine(), false)
    }
}
