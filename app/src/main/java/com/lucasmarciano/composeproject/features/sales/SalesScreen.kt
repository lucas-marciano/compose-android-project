package com.lucasmarciano.composeproject.features.sales

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.features.sales.header.HeaderSalesScreen
import com.lucasmarciano.composeproject.features.sales.timeline.TimeLineScreen
import com.lucasmarciano.composeproject.ui.components.toolbar.CollapseToolbar
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent
import com.lucasmarciano.composeproject.ui.values.TypeToolbar

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
        CollapseToolbar(
            toolbar = ToolbarComponent(
                title = stringResource(R.string.my_business_toolbar_sale_name),
                type = TypeToolbar.BLUE
                ),
            header = { HeaderSalesScreen() },
            content = { TimeLineScreen(navController) }
        )
    }
}