package com.lucasmarciano.composeproject.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
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
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.features.models.ItemCardHome
import com.lucasmarciano.composeproject.ui.components.BlueCard
import com.lucasmarciano.composeproject.ui.components.CardWithIcon
import com.lucasmarciano.composeproject.ui.components.ContainerCircleLoading
import com.lucasmarciano.composeproject.ui.components.SecondTitle
import com.lucasmarciano.composeproject.ui.components.Title
import com.lucasmarciano.composeproject.ui.components.WhiteToolbar
import com.lucasmarciano.composeproject.ui.mockspreview.mockListItemCard
import com.lucasmarciano.composeproject.ui.mockspreview.mockListSimpleItemCardWithIcon
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.theme.HomeAvatar
import com.lucasmarciano.composeproject.ui.theme.StoreIcon

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            Scaffold(
                topBar = { WhiteToolbar(R.string.app_name) },
                content = {
                    HomeContent()
                }
            )
        }

    }
}

@Composable
fun HomeContent(isLoading: Boolean = true) {
    ContainerCircleLoading(isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            HomeTitle()
            Spacer(modifier = Modifier.height(16.dp))
            BlueCardsList(cards = mockListItemCard())

            Spacer(modifier = Modifier.height(18.dp))

            SecondTitle(stringResource(id = R.string.label_selling))
            CardsList(mockListSimpleItemCardWithIcon())
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
        Spacer(modifier = Modifier.height(12.dp))
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
fun BlueCardsList(cards: List<ItemCardHome>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(cards) { card ->
            BlueCard(item = card)
        }
    }
}

@Composable
fun CardsList(cards: List<ItemCardHome>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(end = 8.dp, bottom = 8.dp)
    ) {
        items(cards) { card ->
            CardWithIcon(item = card)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    ComposeProjectTheme {
        HomeContent()
    }
}


@Preview(showBackground = true)
@Composable
fun HomeContentNoLoadingPreview() {
    ComposeProjectTheme {
        HomeContent(isLoading = false)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTitlePreview() {
    ComposeProjectTheme {
        HomeTitle()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTitleWithNotificationPreview() {
    ComposeProjectTheme {
        HomeTitle(hasNotification = true)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBlueCardsPreview() {
    ComposeProjectTheme {
        BlueCardsList(cards = mockListItemCard())
    }
}


@Preview(showBackground = true)
@Composable
fun HomeCardsPreview() {
    ComposeProjectTheme {
        CardsList(cards = mockListSimpleItemCardWithIcon())
    }
}