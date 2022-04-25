package com.lucasmarciano.composeproject.features.settings

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.lucasmarciano.composeproject.features.settings.components.ShimmerSettingsController
import com.lucasmarciano.composeproject.ui.InterfaceFactory
import com.lucasmarciano.composeproject.ui.components.MainContainer
import com.lucasmarciano.composeproject.ui.values.InterfaceItemVO

@Composable
fun SettingsContent(state: SettingsUIState) {
    when (state) {
        is SettingsUIState.Loading -> SettingsScreen()
        is SettingsUIState.Success -> SettingsScreen(
            isLoading = false,
            listItems = state.data.listItems
        )
        is SettingsUIState.Error -> {
            Toast.makeText(
                LocalContext.current,
                "houve um erro: ${state.error.message}",
                Toast.LENGTH_LONG
            ).show()
            SettingsScreen(isLoading = false)
        }
    }
}

@Composable
private fun SettingsScreen(
    isLoading: Boolean = true,
    listItems: List<InterfaceItemVO> = emptyList()
) {
    ShimmerSettingsController(isLoading) {
        MainContainer {
            InterfaceFactory(listItems)
        }
    }
}
