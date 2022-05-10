package com.lucasmarciano.composeproject.features.settings

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.features.settings.components.ShimmerSettingsController
import com.lucasmarciano.composeproject.ui.InterfaceFactory
import com.lucasmarciano.composeproject.ui.components.MainContainer
import com.lucasmarciano.composeproject.ui.values.InterfaceItemComponent

@Composable
fun SettingsScreen(navController: NavController) {
    val viewModel = viewModel<SettingsViewModel>()
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = LocalContext.current) { viewModel.fetchData() }

    when (state) {
        is SettingsUIState.Loading -> SettingsContent()
        is SettingsUIState.Success -> SettingsContent(
            isLoading = false,
            listItems = (state as SettingsUIState.Success).data.listItems,
            navController = navController
        )
        is SettingsUIState.Error -> {
            Toast.makeText(
                LocalContext.current,
                "houve um erro: ${(state as SettingsUIState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
            SettingsContent(isLoading = false)
        }
    }
}

@Composable
private fun SettingsContent(
    isLoading: Boolean = true,
    listItems: List<InterfaceItemComponent> = emptyList(),
    navController: NavController = rememberNavController()
) {
    ShimmerSettingsController(isLoading) {
        MainContainer {
            InterfaceFactory(listItems, navController)
        }
    }
}
