@file:OptIn(ExperimentalAnimationApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.lucasmarciano.composeproject.features.sales

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucasmarciano.composeproject.features.sales.header.HeaderSalesScreen
import com.lucasmarciano.composeproject.features.sales.timeline.TimeLineScreen
import com.lucasmarciano.composeproject.routes.Screen
import com.lucasmarciano.composeproject.ui.components.toolbar.CollapseToolbar
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent
import com.lucasmarciano.composeproject.ui.values.TypeToolbar
import com.lucasmarciano.composeproject.utils.extensions.emptyString
import com.lucasmarciano.composeproject.utils.extensions.navBackTo
import com.lucasmarciano.iti_module.ItiTheme

@Composable
fun SalesScreen(navController: NavController = rememberAnimatedNavController()) {
    SalesContent(navController)
}

@Composable
private fun SalesContent(navController: NavController) {
    Column(
        modifier = Modifier
            .background(ItiTheme.colors.bg)
            .fillMaxSize()
    ) {

        CollapseToolbar(
            toolbar = ToolbarComponent(
                title = emptyString(),
                type = TypeToolbar.BLUE
            ),
            onClickBack = { navController.navBackTo(Screen.HomeScreen.buildPath()) },
            onClick = {},
            header = { HeaderSalesScreen() },
            content = {
                TimeLineScreen { saleId -> goToDetail(saleId, navController) }
            },
        )
    }
}

private fun goToDetail(saleId: String, navController: NavController) {
    navController.navigate(Screen.DetailSale.mountPathWithArgs(saleId))
}
