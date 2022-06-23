@file:OptIn(ExperimentalAnimationApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucasmarciano.composeproject.ui.Components
import com.lucasmarciano.composeproject.ui.InterfaceFactory
import com.lucasmarciano.composeproject.ui.components.toolbar.Toolbar
import com.lucasmarciano.composeproject.ui.mockspreview.mockHomeResult
import com.lucasmarciano.composeproject.ui.values.InterfaceItemComponent
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent
import com.lucasmarciano.composeproject.utils.extensions.navBackTo
import com.lucasmarciano.ui.iti.theme.ItiTheme

@Composable
internal fun MainContainer(
    navController: NavController,
    listItems: List<InterfaceItemComponent> = emptyList(),
    state: LazyListState = rememberLazyListState(),
) {
    var toolbar: ToolbarComponent? = null
    if (listItems.isNotEmpty()) {
        val toolbarData = listItems.find { it.typeComponent == Components.TOOLBAR }
        toolbar = (toolbarData as ToolbarComponent)
    }

    LazyColumn(
        state = state,
        modifier = Modifier
            .background(ItiTheme.colors.bg)
            .fillMaxSize()
    ) {
        toolbar?.let { bar ->
            item {
                Toolbar(
                    toolbar = toolbar,
                    onClick = { navController.navBackTo(bar.backTo) }
                )
            }
        }
        items(listItems) { component ->
            Column(
                modifier = Modifier
                    .background(ItiTheme.colors.bg)
                    .padding(
                        start = ItiTheme.spacing.medium,
                        end = ItiTheme.spacing.medium,
                        top = ItiTheme.spacing.medium
                    )
            ) {
                InterfaceFactory(component, navController)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun MainContainerHomePreview() {
    ItiTheme(darkTheme = false) {
        val navController = rememberAnimatedNavController()
        MainContainer(navController, mockHomeResult().listItems)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkMainContainerHomePreview() {
    ItiTheme(darkTheme = true) {
        val navController = rememberAnimatedNavController()
        MainContainer(navController, mockHomeResult().listItems)
    }
}
