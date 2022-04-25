package com.lucasmarciano.composeproject.features.home

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.lucasmarciano.composeproject.features.home.components.ShimmerHomeController
import com.lucasmarciano.composeproject.ui.InterfaceFactory
import com.lucasmarciano.composeproject.ui.components.MainContainer
import com.lucasmarciano.composeproject.ui.values.InterfaceItemVO

@Composable
fun HomeContent(state: HomeUIState) {
    when (state) {
        is HomeUIState.Loading -> MainContent()
        is HomeUIState.Success -> MainContent(isLoading = false, listItems = state.data.listItems)
        is HomeUIState.Error -> {
            Toast.makeText(
                LocalContext.current,
                "houve um erro: ${state.error.message}",
                Toast.LENGTH_LONG
            ).show()
            MainContent(isLoading = false)
        }
    }
}

@Composable
private fun MainContent(isLoading: Boolean = true, listItems: List<InterfaceItemVO> = emptyList()) {
    ShimmerHomeController(isLoading) {
        MainContainer {
            InterfaceFactory(listItems)
        }
    }
}
