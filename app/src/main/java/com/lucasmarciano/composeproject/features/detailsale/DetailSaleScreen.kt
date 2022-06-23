@file:OptIn(ExperimentalAnimationApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.lucasmarciano.composeproject.features.detailsale

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun DetailSaleScreen(
    saleId: String? = null,
    navController: NavController = rememberAnimatedNavController()
) {
    val viewModel = viewModel<DetailSaleViewModel>()

    saleId?.let {
        viewModel.fetchData(it)
        val state by viewModel.uiState.collectAsState()

    } ?: GoToError(navController)

}

@Composable
private fun GoToError(navController: NavController) {
}

@Composable
private fun DetailSaleContent() {
}
