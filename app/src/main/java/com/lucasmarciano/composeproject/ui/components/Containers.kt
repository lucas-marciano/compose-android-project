package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.ui.Components
import com.lucasmarciano.composeproject.ui.InterfaceFactory
import com.lucasmarciano.composeproject.ui.mockspreview.mockHomeResult
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing
import com.lucasmarciano.composeproject.ui.values.InterfaceItemComponent
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent

@Composable
internal fun MainContainer(
    navController: NavController,
    listItems: List<InterfaceItemComponent> = emptyList(),
) {
    var toolbar: ToolbarComponent? = null
    if (listItems.isNotEmpty()) {
        val toolbarData = listItems.find { it.typeComponent == Components.TOOLBAR }
        toolbar = (toolbarData as ToolbarComponent)
    }

    ComposeProjectTheme {
        LazyColumn(modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()) {
            item {
                Toolbar(
                    toolbar = toolbar,
                    navController = navController
                )
            }
            items(listItems) { component ->
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .padding(
                            top = MaterialTheme.spacing.medium,
                            start = MaterialTheme.spacing.medium,
                            end = MaterialTheme.spacing.medium
                        )
                ) {
                    InterfaceFactory(component, navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun MainContainerHomePreview() {
    ComposeProjectTheme(darkTheme = false) {
        val navController = rememberNavController()
        MainContainer(navController, mockHomeResult().listItems)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkMainContainerHomePreview() {
    ComposeProjectTheme(darkTheme = true) {
        val navController = rememberNavController()
        MainContainer(navController, mockHomeResult().listItems)
    }
}
