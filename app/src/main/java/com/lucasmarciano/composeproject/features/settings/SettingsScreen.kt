@file:OptIn(ExperimentalAnimationApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.lucasmarciano.composeproject.features.settings

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
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
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucasmarciano.composeproject.features.settings.components.ShimmerSettingsController
import com.lucasmarciano.composeproject.ui.components.MainContainer
import com.lucasmarciano.composeproject.ui.mockspreview.mockSettingsResult
import com.lucasmarciano.composeproject.ui.values.InterfaceItemComponent

@Composable
fun SettingsScreen(navController: NavController) {
    val viewModel = viewModel<SettingsViewModel>()
    val state by viewModel.uiState.collectAsState()

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
    navController: NavController = rememberAnimatedNavController()
) {
    val mListItems by remember { mutableStateOf(listItems) }
    val mIsLoading by remember { mutableStateOf(isLoading) }
    val state = rememberLazyListState()

    ShimmerSettingsController(mIsLoading) {
        MainContainer(navController, mListItems, state)
    }
}

@Preview(name = "Settings Content", backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun SettingsContentPreview() {
    SettingsContent(false, mockSettingsResult().listItems)
}

@Preview(
    name = "Settings Content Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun SettingsContentDarkPreview() {
    SettingsContent(false, mockSettingsResult().listItems)
}

@Preview(name = "Settings Content Loading", backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun SettingsContentLoadingPreview() {
    SettingsContent()
}

@Preview(
    name = "Settings Content Loading Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun SettingsContentLoadingDarkPreview() {
    SettingsContent()
}