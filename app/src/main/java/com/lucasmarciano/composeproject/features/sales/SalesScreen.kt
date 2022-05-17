package com.lucasmarciano.composeproject.features.sales

import android.widget.Toast
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.ui.values.InterfaceItemComponent

@Composable
fun SalesScreen(navController: NavController = rememberNavController()) {
    val viewModel = viewModel<SalesViewModel>()
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is SalesUIState.Loading -> SalesContent()
        is SalesUIState.Success -> SalesContent(
            isLoading = false,
            listItems = (state as SalesUIState.Success).data.listItems,
            navController
        )
        is SalesUIState.Error -> {
            Toast.makeText(
                LocalContext.current,
                "houve um erro: ${(state as SalesUIState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
            SalesContent(isLoading = false)
        }
    }
}

@Composable
private fun SalesContent(
    isLoading: Boolean = true,
    listItems: List<InterfaceItemComponent> = emptyList(),
    navController: NavController = rememberNavController()
) {
    val mListItems by remember { mutableStateOf(listItems) }
    val mIsLoading by remember { mutableStateOf(isLoading) }
    val state = rememberLazyListState()

}