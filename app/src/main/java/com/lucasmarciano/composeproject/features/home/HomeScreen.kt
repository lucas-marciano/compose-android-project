package com.lucasmarciano.composeproject.features.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.data.models.BannerVO
import com.lucasmarciano.composeproject.ui.components.Banner
import com.lucasmarciano.composeproject.ui.components.BlueCard
import com.lucasmarciano.composeproject.ui.components.CardWithIcon
import com.lucasmarciano.composeproject.ui.components.ContainerCircleLoading
import com.lucasmarciano.composeproject.ui.components.SecondTitle
import com.lucasmarciano.composeproject.ui.components.Title
import com.lucasmarciano.composeproject.ui.mockspreview.mockHomeUIState
import com.lucasmarciano.composeproject.ui.mockspreview.mockHomeUIStateWithLoading
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.theme.HomeAvatar
import com.lucasmarciano.composeproject.ui.theme.StoreIcon
import com.lucasmarciano.composeproject.ui.utils.spacing

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

            banner?.let {
                SecondTitle(stringResource(id = R.string.label_emphasis))
                Banner(banner)
            }
        }
    }
}

@Composable
fun HomeTitle(
    name: String = stringResource(id = R.string.label_my_business),
    hasNotification: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HomeAvatar()
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Title(name)
            StoreIcon(hasNotification = hasNotification)
        }
    }
}

@Composable
fun BlueCardsList(cards: List<ItemCardHomeVO>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)) {
        items(cards) { card ->
            BlueCard(item = card)
        }
    }
}

@Composable
fun CardsList(cards: List<ItemCardHomeVO>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
        contentPadding = PaddingValues(
            end = MaterialTheme.spacing.small,
            bottom = MaterialTheme.spacing.small
        )
    ) {
        items(cards) { card ->
            CardWithIcon(item = card)
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

@Preview("Title")
@Composable
fun HomeTitlePreview() {
    ComposeProjectTheme(darkTheme = false) {
        HomeTitle()
    }
}

@Preview("Title with icon notification")
@Composable
fun HomeTitleWithNotificationPreview() {
    ComposeProjectTheme(darkTheme = false) {
        HomeTitle(hasNotification = true)
    }
}
