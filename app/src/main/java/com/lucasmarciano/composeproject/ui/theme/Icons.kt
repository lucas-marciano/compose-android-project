package com.lucasmarciano.composeproject.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasmarciano.composeproject.R

@Composable
fun BackIcon(@StringRes contentDescription: Int = R.string.content_description_back_button_toolbar) {
    Icon(
        painter = painterResource(id = R.drawable.ic_left_arrow),
        contentDescription = stringResource(id = contentDescription)
    )
}

@Composable
fun HelpIcon(@StringRes contentDescription: Int = R.string.content_description_back_button_toolbar) {
    Icon(
        painter = painterResource(id = R.drawable.ic_help_information),
        contentDescription = stringResource(id = contentDescription)
    )
}

@Composable
fun StoreIcon(
    @StringRes contentDescription: Int = R.string.content_description_store_icon,
    hasNotification: Boolean = true
) {
    if (hasNotification) {
        Icon(
            painter = painterResource(id = R.drawable.ic_store_menu_with_notification),
            contentDescription = stringResource(id = contentDescription)
        )
    } else {
        Icon(
            painter = painterResource(id = R.drawable.ic_store_menu),
            contentDescription = stringResource(id = contentDescription)
        )
    }
}

@Composable
fun HomeAvatar(shape: Shape = CircleShape) {
    Box(
        modifier = Modifier
            .size(45.dp)
            .clip(shape)
            .background(Color.Magenta)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultIconsPreview() {
    ComposeProjectTheme {
        Column {
            BackIcon()
            HelpIcon()
            StoreIcon(hasNotification = false)
            StoreIcon(hasNotification = true)
            HomeAvatar()
        }
    }
}