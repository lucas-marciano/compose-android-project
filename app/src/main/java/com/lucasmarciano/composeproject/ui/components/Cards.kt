package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCard
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCardWithIcon
import com.lucasmarciano.composeproject.ui.mockspreview.mockSimpleItemCardWithIcon
import com.lucasmarciano.composeproject.ui.theme.CoinIcon
import com.lucasmarciano.ui.iti.theme.colors.ColorBlueCard
import com.lucasmarciano.ui.iti.theme.colors.ColorPinkCalifornia
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
fun BlueCard(item: ItemCardHomeVO, onClick: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .height(ComposeProjectTheme.spacing.cardHeight)
            .width(ComposeProjectTheme.spacing.cardWidth)
            .clip(RoundedCornerShape(ComposeProjectTheme.spacing.small))
            .background(ColorBlueCard)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(ComposeProjectTheme.spacing.defaultPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.text,
                color = Color.White,
                style = ComposeProjectTheme.type.body1,
            )
            if (item.hasIcon()) {
                CoinIcon(
                    size = ComposeProjectTheme.spacing.largeIcon,
                    color = Color.White
                )
            }
        }
    }
}


@Composable
fun CardWithIcon(item: ItemCardHomeVO, onClick: () -> Unit = { }) {
    Card(
        modifier = Modifier
            .height(ComposeProjectTheme.spacing.extraHuge)
            .width(ComposeProjectTheme.spacing.extraHuge)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(ComposeProjectTheme.spacing.small),
        elevation = ComposeProjectTheme.elevation.extraSmall,
        backgroundColor = ComposeProjectTheme.colors.bg
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(ComposeProjectTheme.spacing.defaultPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                modifier = Modifier.size(ComposeProjectTheme.spacing.smallIcon),
                painter = painterResource(id = R.drawable.ic_money_info),
                contentDescription = "",
                tint = ColorPinkCalifornia
            )
            Text(
                text = item.text,
                color = ComposeProjectTheme.colors.onBg,
                style = ComposeProjectTheme.type.subtitle2,
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlueBoxPreview() {
    ComposeProjectTheme {
        BlueCard(mockItemCard())
    }
}

@Preview(showBackground = true)
@Composable
fun BlueBoxWithIconPreview() {
    ComposeProjectTheme {
        BlueCard(mockItemCardWithIcon())
    }
}


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ComposeProjectTheme {
        CardWithIcon(mockSimpleItemCardWithIcon())
    }
}
