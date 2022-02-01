package com.lucasmarciano.composeproject.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.ui.theme.BackIcon
import com.lucasmarciano.composeproject.ui.theme.ColorPinkCalifornia
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.theme.HelpIcon
import com.lucasmarciano.composeproject.ui.utils.elevation

@Composable
fun WhiteToolbar(@StringRes title: Int = R.string.label_empty) {
    ComposeProjectTheme {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background,
            title = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = title),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    BackIcon(color = ColorPinkCalifornia)
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    HelpIcon(color = ColorPinkCalifornia)
                }
            },
            elevation = MaterialTheme.elevation.noElevation
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ToolbarPreview() {
    ComposeProjectTheme(darkTheme = false) {
        WhiteToolbar()
    }
}


@Preview(showBackground = true)
@Composable
fun DarkToolbarPreview() {
    ComposeProjectTheme(darkTheme = true) {
        WhiteToolbar(R.string.app_name)
    }
}
