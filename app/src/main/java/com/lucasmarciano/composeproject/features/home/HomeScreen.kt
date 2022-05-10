package com.lucasmarciano.composeproject.features.home

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.features.home.components.ShimmerHomeController
import com.lucasmarciano.composeproject.ui.Components
import com.lucasmarciano.composeproject.ui.InterfaceFactory
import com.lucasmarciano.composeproject.ui.components.MainContainer
import com.lucasmarciano.composeproject.ui.mockspreview.mockHomeResult
import com.lucasmarciano.composeproject.ui.values.InterfaceItemComponent
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent

@Composable
fun HomeScreen(navController: NavController) {
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
    var toolbar: ToolbarComponent? = null
    if (listItems.isNotEmpty()) {
        val toolbarData = listItems.find { it.typeComponent == Components.TOOLBAR }
        toolbar = (toolbarData as ToolbarComponent)
    }
    ShimmerHomeController(isLoading) {
        MainContainer(toolbarData = toolbar, navController) {
            InterfaceFactory(listItems, navController)
        }
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
