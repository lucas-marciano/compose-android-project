package com.lucasmarciano.composeproject.ui.components.toolbar

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.ui.theme.BackIcon
import com.lucasmarciano.composeproject.ui.theme.ColorBlueCard
import com.lucasmarciano.composeproject.ui.theme.ColorPinkCalifornia
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.theme.HelpIcon
import com.lucasmarciano.composeproject.ui.utils.elevation
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent
import com.lucasmarciano.composeproject.ui.values.ToolbarContextualMenu
import com.lucasmarciano.composeproject.ui.values.TypeToolbar

@Composable
internal fun Toolbar(
    toolbar: ToolbarComponent?,
    onClick: (String) -> Unit = { },
    onClickMenu: () -> Unit = { }
) {
    toolbar?.let {
        val backgroundColor = when (toolbar.type) {
            TypeToolbar.NORMAL -> MaterialTheme.colors.background
            TypeToolbar.BLUE -> ColorBlueCard
        }
        TopAppBar(
            backgroundColor = backgroundColor,
            title = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = toolbar.title,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.subtitle1,
                        color = getColorTitle(toolbar.type)
                    )
                }
            },
            navigationIcon = {
                BuildBackAction(toolbar = toolbar, onClick = onClick)
            },
            actions = { BuildAction(toolbar, onClickMenu) },
            elevation = MaterialTheme.elevation.noElevation
        )
    }
}

@Composable
internal fun BuildAction(toolbar: ToolbarComponent, onClick: () -> Unit = { }) {
    return when (toolbar.contextualMenu) {
        ToolbarContextualMenu.HELP -> {
            IconButton(onClick = onClick) {
                HelpIcon(color = getColorIcons(toolbar.type))
            }
        }
        else -> {}
    }
}

@Composable
internal fun BuildBackAction(
    toolbar: ToolbarComponent,
    onClick: (String) -> Unit = { },
) {
    return IconButton(onClick = { onClick(toolbar.backTo) }) {
        BackIcon(color = getColorIcons(toolbar.type))
    }
}

private fun getColorIcons(type: TypeToolbar) = when (type) {
    TypeToolbar.BLUE -> Color.White
    else -> ColorPinkCalifornia
}

@Composable
fun getColorTitle(type: TypeToolbar) = when (type) {
    TypeToolbar.BLUE -> Color.White
    else -> MaterialTheme.colors.onBackground
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ToolbarPreview() {
    ComposeProjectTheme(darkTheme = false) {
        val toolbar = ToolbarComponent(
            title = "title",
            contextualMenu = ToolbarContextualMenu.HELP
        )
        Toolbar(toolbar)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ToolbarBluePreview() {
    ComposeProjectTheme(darkTheme = false) {
        val toolbar = ToolbarComponent(
            title = "title",
            type = TypeToolbar.BLUE,
            contextualMenu = ToolbarContextualMenu.HELP
        )
        Toolbar(toolbar)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkToolbarPreview() {
    ComposeProjectTheme(darkTheme = true) {
        val toolbar = ToolbarComponent(
            title = "title",
            contextualMenu = ToolbarContextualMenu.HELP
        )
        Toolbar(toolbar)
    }
}
