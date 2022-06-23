package com.lucasmarciano.composeproject.ui.theme

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.utils.extensions.emptyString
import com.lucasmarciano.ui.iti.theme.colors.ColorPinkCalifornia
import com.lucasmarciano.ui.iti.theme.colors.ColorPinkCaliforniaVariant

@Composable
fun BackIcon(
    @StringRes contentDescription: Int = R.string.content_description_back_button_toolbar,
    color: Color = ComposeProjectTheme.colors.onBrand
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_left_arrow),
        contentDescription = stringResource(id = contentDescription),
        tint = color,
        modifier = Modifier
            .height(ComposeProjectTheme.spacing.large)
            .width(ComposeProjectTheme.spacing.large)
            .padding(ComposeProjectTheme.spacing.extraSmall)
    )
}

@Composable
fun HelpIcon(
    @StringRes contentDescription: Int = R.string.content_description_back_button_toolbar,
    color: Color = ComposeProjectTheme.colors.onBrand
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_help_information),
        contentDescription = stringResource(id = contentDescription),
        tint = color,
        modifier = Modifier
            .height(ComposeProjectTheme.spacing.large)
            .width(ComposeProjectTheme.spacing.large)
            .padding(ComposeProjectTheme.spacing.extraSmall)
    )
}

@Composable
fun CoinIcon(
    @StringRes contentDescription: Int = R.string.content_description_money_icon,
    color: Color = ComposeProjectTheme.colors.onBrand,
    size: Dp = ComposeProjectTheme.spacing.large,
) {
    Icon(
        modifier = Modifier
            .size(size)
            .padding(ComposeProjectTheme.spacing.extraSmall),
        painter = painterResource(id = R.drawable.ic_money_info),
        contentDescription = stringResource(id = contentDescription),
        tint = color,
    )
}

@Composable
fun StoreIcon(
    @StringRes contentDescription: Int = R.string.content_description_store_icon,
    hasNotification: Boolean = true,
    onClick: () -> Unit = { }
) {
    Box(
        modifier = Modifier.selectable(selected = true, enabled = true, onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_store_menu),
            contentDescription = stringResource(id = contentDescription),
            tint = ComposeProjectTheme.colors.onBrand,
            modifier = Modifier
                .clickable(onClick = onClick)
                .height(ComposeProjectTheme.spacing.large)
                .width(ComposeProjectTheme.spacing.large)
        )
        if (hasNotification) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(ColorPinkCaliforniaVariant)
                    .align(alignment = Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun HomeAvatar(avatar: String = emptyString()) {
    Box(
        modifier = Modifier
            .size(ComposeProjectTheme.spacing.huge)
            .clip(CircleShape)
            .background(ColorPinkCalifornia)
            .padding(ComposeProjectTheme.spacing.extraSmall)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun DefaultIconsPreview() {
    ComposeProjectTheme {
        Column {
            BackIcon()
            BackIcon(color = ColorPinkCalifornia)
            HelpIcon()
            HelpIcon(color = ColorPinkCalifornia)
            StoreIcon(hasNotification = false)
            StoreIcon(hasNotification = true)
            CoinIcon()
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultIconsDarkPreview() {
    ComposeProjectTheme {
        Column {
            BackIcon()
            BackIcon(color = ColorPinkCalifornia)
            HelpIcon()
            HelpIcon(color = ColorPinkCalifornia)
            StoreIcon(hasNotification = false)
            StoreIcon(hasNotification = true)
            CoinIcon()
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun AvatarIconPreview() {
    ComposeProjectTheme {
        HomeAvatar()
    }
}