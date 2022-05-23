package com.lucasmarciano.composeproject.features.sales.header

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.features.sales.components.ShimmerSalesHeaderController
import com.lucasmarciano.composeproject.ui.components.SecondTitle
import com.lucasmarciano.composeproject.ui.components.Title
import com.lucasmarciano.composeproject.ui.theme.ColorSalesToolbar
import com.lucasmarciano.composeproject.ui.values.InterfaceItemComponent

@Composable
fun HeaderSalesScreen(navController: NavController = rememberNavController()) {
    val viewModel = viewModel<HeaderSalesViewModel>()
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is HeaderSalesUIState.Loading -> HeaderSalesContent()
        is HeaderSalesUIState.Success -> HeaderSalesContent(
            isLoading = false,
            listItems = (state as HeaderSalesUIState.Success).data.listItems,
            navController
        )
        is HeaderSalesUIState.Error -> {
            Toast.makeText(
                LocalContext.current,
                "houve um erro: ${(state as HeaderSalesUIState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
            HeaderSalesContent(isLoading = false)
        }
    }
}

@Composable
private fun HeaderSalesContent(
    isLoading: Boolean = true,
    listItems: List<InterfaceItemComponent> = emptyList(),
    navController: NavController = rememberNavController()
) {
    val mListItems by remember { mutableStateOf(listItems) }
    val mIsLoading by remember { mutableStateOf(isLoading) }
    val state = rememberLazyListState()

    ShimmerSalesHeaderController(isLoading = isLoading) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ) {
            Column {
                Column(
                    modifier = Modifier
                        .background(ColorSalesToolbar)
                        .padding(all = 24.dp)
                        .fillMaxWidth()
                ) {

                    SecondTitle("value")

                    Title("value")

                    Title("value")
                }
                Surface(
                    elevation = 4.dp, modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "item 1")
                        Text(text = "item 2")
                    }
                }
            }
        }
    }
}
