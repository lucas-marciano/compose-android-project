package com.lucasmarciano.composeproject.features.home

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.features.home.components.ShimmerHomeController
import com.lucasmarciano.composeproject.ui.components.MainContainer
import com.lucasmarciano.composeproject.ui.mockspreview.mockHomeResult
import com.lucasmarciano.composeproject.ui.values.InterfaceItemComponent

@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    val viewModel = viewModel<HomeViewModel>()
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is HomeUIState.Loading -> HomeContent()
        is HomeUIState.Success -> HomeContent(
            isLoading = false,
            listItems = (state as HomeUIState.Success).data.listItems,
            navController
        )
        is HomeUIState.Error -> {
            Toast.makeText(
                LocalContext.current,
                "houve um erro: ${(state as HomeUIState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
            HomeContent(isLoading = false)
        }
    }
}

@Composable
private fun HomeContent(
    isLoading: Boolean = true,
    listItems: List<InterfaceItemComponent> = emptyList(),
    navController: NavController = rememberNavController()
) {
    val mListItems by remember { mutableStateOf(listItems) }
    val mIsLoading by remember { mutableStateOf(isLoading) }
    val state = rememberLazyListState()

    ShimmerHomeController(mIsLoading) {
        MainContainer(navController, mListItems, state)
    }
}

@Preview(name = "Home Content", backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun HomeContentPreview() {
    HomeContent(false, mockHomeResult().listItems)
}

@Preview(
    name = "Home Content Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun HomeContentDarkPreview() {
    HomeContent(false, mockHomeResult().listItems)
}

@Preview(name = "Home Content Loading", backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun HomeContentLoadingPreview() {
    HomeContent()
}

@Preview(
    name = "Home Content Loading Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun HomeContentLoadingDarkPreview() {
    HomeContent()
}
