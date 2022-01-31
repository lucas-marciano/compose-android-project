package com.lucasmarciano.composeproject.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
fun BackIcon(
    @StringRes contentDescription: Int = R.string.content_description_back_button_toolbar,
    color: Color = MaterialTheme.colors.primary
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_left_arrow),
        contentDescription = stringResource(id = contentDescription),
        tint = color
    )
}

@Composable
fun HelpIcon(
    @StringRes contentDescription: Int = R.string.content_description_back_button_toolbar,
    color: Color = MaterialTheme.colors.primary
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_help_information),
        contentDescription = stringResource(id = contentDescription),
        tint = color
    )
}

@Composable
fun CoinIcon(
    @StringRes contentDescription: Int = R.string.content_description_money_icon,
    color: Color = MaterialTheme.colors.primary,
    size: Dp = MaterialTheme.spacing.extraMedium,
) {
    Icon(
        modifier = Modifier.size(size),
        painter = painterResource(id = R.drawable.ic_money_info),
        contentDescription = stringResource(id = contentDescription),
        tint = color
    )
}

@Composable
fun StoreIcon(
    @StringRes contentDescription: Int = R.string.content_description_store_icon,
    hasNotification: Boolean = true,
    onClick: () -> Unit = { }
) {
    if (hasNotification) {
        Icon(
            painter = painterResource(id = R.drawable.ic_store_menu),
            contentDescription = stringResource(id = contentDescription),
            tint = MaterialTheme.colors.onPrimary,
            modifier = Modifier.clickable(onClick = onClick)
        )
    } else {
        Icon(
            painter = painterResource(id = R.drawable.ic_store_menu),
            contentDescription = stringResource(id = contentDescription),
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}

@Composable
fun HomeAvatar(onClick: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .size(MaterialTheme.spacing.huge)
            .clip(CircleShape)
            .background(ColorPinkCalifornia)
            .clickable(onClick = onClick)
    )
}

@Preview(showBackground = false)
@Composable
fun DefaultIconsPreview() {
    ComposeProjectTheme {
        Column {
            BackIcon()
            BackIcon(color = Color.White)
            HelpIcon()
            HelpIcon(color = Color.White)
            StoreIcon(hasNotification = false)
            StoreIcon(hasNotification = true)
            CoinIcon()
        }
    }
}


@Preview(showBackground = false)
@Composable
fun AvatarIconPreview() {
    ComposeProjectTheme {
        HomeAvatar()
    }
}