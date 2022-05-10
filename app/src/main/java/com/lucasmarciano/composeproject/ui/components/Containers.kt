package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent
import com.lucasmarciano.composeproject.ui.values.ToolbarContextualMenu

@Composable
internal fun MainContainer(
    toolbarData: ToolbarComponent? = null,
    navController: NavController,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                toolbar = toolbarData,
                navController = navController
            )
        }) {
        ComposeProjectTheme {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = MaterialTheme.spacing.medium,
                        start = MaterialTheme.spacing.medium,
                        end = MaterialTheme.spacing.medium
                    )
            ) {
                item {
                    content()
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun MainContainerPreview() {
    ComposeProjectTheme(darkTheme = false) {
        val toolbar = ToolbarComponent(
            title = "title",
            contextualMenu = ToolbarContextualMenu.HELP
        )
        val navController = rememberNavController()
        MainContainer(toolbar, navController) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Red),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "test", modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkMainContainerPreview() {
    ComposeProjectTheme(darkTheme = true) {
        val toolbar = ToolbarComponent(
            title = "title",
            contextualMenu = ToolbarContextualMenu.HELP
        )
        val navController = rememberNavController()
        MainContainer(toolbar, navController) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "test", modifier = Modifier.fillMaxSize())
            }
        }
    }
}
