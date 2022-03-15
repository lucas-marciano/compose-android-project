package com.lucasmarciano.composeproject.features.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.data.models.BannerVO
import com.lucasmarciano.composeproject.features.home.components.BlueCardsList
import com.lucasmarciano.composeproject.features.home.components.CardsList
import com.lucasmarciano.composeproject.features.home.components.HomeTitle
import com.lucasmarciano.composeproject.ui.InterfaceFactory
import com.lucasmarciano.composeproject.ui.components.Banner
import com.lucasmarciano.composeproject.ui.components.ContainerCircleLoading
import com.lucasmarciano.composeproject.ui.components.SecondTitle
import com.lucasmarciano.composeproject.ui.mockspreview.mockHomeUIState
import com.lucasmarciano.composeproject.ui.mockspreview.mockHomeUIStateWithLoading
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing
import com.lucasmarciano.composeproject.ui.values.InterfaceItem

@Composable
fun HomeContent(state: HomeUIState) {
    when (state) {
        is HomeUIState.Loading -> Content()
        is HomeUIState.Success -> Content(
            isLoading = false,
            state.response.listBlueCard,
            state.response.listSimpleCard,
            state.response.bannerInfo
        )
        is HomeUIState.Error -> {
            Toast.makeText(
                LocalContext.current,
                "houve um erro: ${state.error.message}",
                Toast.LENGTH_LONG
            ).show()
            Content(isLoading = false)
            TODO("build a error screen")
        }
    }
}

@Composable
private fun MainContent(
    isLoading: Boolean = true,
    listItems: List<InterfaceItem>
) {
    val scrollState = rememberScrollState()

    ContainerCircleLoading(isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = MaterialTheme.spacing.medium,
                    start = MaterialTheme.spacing.medium,
                    end = MaterialTheme.spacing.medium
                )
                .verticalScroll(scrollState)
        ) {
            InterfaceFactory(listItems)
        }
    }
}

@Composable
private fun Content(
    isLoading: Boolean = true,
    listBlueCard: List<ItemCardHomeVO> = emptyList(),
    listSimpleCard: List<ItemCardHomeVO> = emptyList(),
    banner: BannerVO? = null,
) {
    val scrollState = rememberScrollState()

    ContainerCircleLoading(isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = MaterialTheme.spacing.medium,
                    start = MaterialTheme.spacing.medium,
                    end = MaterialTheme.spacing.medium
                )
                .verticalScroll(scrollState)
        ) {
            HomeTitle()
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            BlueCardsList(listBlueCard)
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            SecondTitle(stringResource(id = R.string.label_selling))
            CardsList(listSimpleCard)
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            SecondTitle(stringResource(id = R.string.label_emphasis))
            Banner(banner)
        }
    }
}

@Preview("Home content show loading")
@Composable
fun HomeContentPreview() {
    ComposeProjectTheme(darkTheme = false) {
        HomeContent(mockHomeUIStateWithLoading())
    }
}

@Preview("Home content no loading")
@Composable
fun HomeContentNoLoadingPreview() {
    ComposeProjectTheme(darkTheme = false) {
        HomeContent(mockHomeUIState())
    }
}
