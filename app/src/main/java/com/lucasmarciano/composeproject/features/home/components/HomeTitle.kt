@file:OptIn(ExperimentalAnimationApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.lucasmarciano.composeproject.features.home.components

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.routes.Screen
import com.lucasmarciano.composeproject.ui.components.Title
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.theme.HomeAvatar
import com.lucasmarciano.composeproject.ui.theme.StoreIcon
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
fun HomeTitle(
    name: String = stringResource(id = R.string.label_my_business),
    hasNotification: Boolean = false,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HomeAvatar()
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Title(text = name)
            StoreIcon(
                hasNotification = hasNotification,
                onClick = { navController.navigate(Screen.SettingsScreen.route) })
        }
    }
}

@Preview(name = "Title", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun HomeTitlePreview() {
    ComposeProjectTheme(darkTheme = false) {
        val nav = rememberAnimatedNavController()
        HomeTitle(navController = nav)
    }
}

@Preview(name = "Title Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeTitleDarkPreview() {
    ComposeProjectTheme(darkTheme = false) {
        val nav = rememberAnimatedNavController()
        HomeTitle(navController = nav)
    }
}

@Preview(name = "Title with icon notification", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun HomeTitleWithNotificationPreview() {
    ComposeProjectTheme(darkTheme = false) {
        val nav = rememberAnimatedNavController()
        HomeTitle(hasNotification = true, navController = nav)
    }
}

@Preview(
    name = "Title with icon notification dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun HomeTitleWithNotificationDarkPreview() {
    ComposeProjectTheme(darkTheme = false) {
        val nav = rememberAnimatedNavController()
        HomeTitle(hasNotification = true, navController = nav)
    }
}
