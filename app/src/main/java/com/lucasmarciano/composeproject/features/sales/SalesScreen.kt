package com.lucasmarciano.composeproject.features.sales

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.features.sales.components.TabItem
import com.lucasmarciano.composeproject.features.sales.header.HeaderSalesScreen
import com.lucasmarciano.composeproject.features.sales.timeline.TimeLineScreen
import com.lucasmarciano.composeproject.routes.Screen
import com.lucasmarciano.composeproject.ui.components.toolbar.CollapseToolbar
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent
import com.lucasmarciano.composeproject.ui.values.TypeToolbar
import com.lucasmarciano.composeproject.utils.extensions.emptyString
import com.lucasmarciano.composeproject.utils.extensions.navBackTo

@Composable
fun SalesScreen(navController: NavController = rememberNavController()) {
    SalesContent(navController)
}

@Composable
private fun SalesContent(navController: NavController) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
    ) {

        var tabSelected by remember { mutableStateOf<TabItem>(TabItem.Selling) }

        CollapseToolbar(
            toolbar = ToolbarComponent(
                title = emptyString(),
                type = TypeToolbar.BLUE
            ),
            onClickBack = { navController.navBackTo(Screen.HomeScreen.route) },
            onClick = {},
            header = { HeaderSalesScreen() },
            content = {
                TimeLineScreen(
                    tabSelected,
                    onTabSelected = { tabSelected = it }
                )
            },
        )
    }
}