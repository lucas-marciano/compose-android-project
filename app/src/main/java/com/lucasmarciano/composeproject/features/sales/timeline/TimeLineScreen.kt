package com.lucasmarciano.composeproject.features.sales.timeline

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.data.models.ItemTimeLineVO
import com.lucasmarciano.composeproject.features.sales.components.ShimmerSalesTimeListController

@Composable
fun TimeLineScreen(navController: NavController = rememberNavController()) {
    val viewModel = viewModel<TimeLineViewModel>()
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is TimeLineUIState.Loading -> TimeLineContent()
        is TimeLineUIState.Success -> TimeLineContent(
            isLoading = false,
            listItems = (state as TimeLineUIState.Success).data,
            navController = navController
        )
        is TimeLineUIState.ErrorEmpty -> {

        }
        is TimeLineUIState.Error -> {
            Toast.makeText(
                LocalContext.current,
                "houve um erro: ${(state as TimeLineUIState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
            TimeLineContent(isLoading = false)
        }
    }
}

@Composable
private fun TimeLineContent(
    isLoading: Boolean = true,
    listItems: List<ItemTimeLineVO> = emptyList(),
    navController: NavController = rememberNavController()
) {
    ShimmerSalesTimeListController(isLoading = isLoading) {

    }
}