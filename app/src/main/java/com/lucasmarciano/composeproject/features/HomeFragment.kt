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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
import com.lucasmarciano.composeproject.ui.utils.spacing

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            ComposeProjectTheme {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.background,
                    topBar = { WhiteToolbar(R.string.app_name) },
                    content = {
                        HomeContent(false)
                    }
                )
            }
        }

    }
}

@Composable
fun HomeContent(isLoading: Boolean = true) {
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
            BlueCardsList(cards = mockListItemCard())

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

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
fun BlueCardsList(cards: List<ItemCardHome>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)) {
        items(cards) { card ->
            BlueCard(item = card)
        }
    }
}

@Composable
fun CardsList(cards: List<ItemCardHome>) {
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

@Preview("Home content show loading", showBackground = true, showSystemUi = true)
@Composable
fun HomeContentPreview() {
    ComposeProjectTheme(darkTheme = false) {
        HomeContent()
    }
}

@Preview("Home content no loading", showBackground = true, showSystemUi = true)
@Composable
fun HomeContentNoLoadingPreview() {
    ComposeProjectTheme(darkTheme = false) {
        HomeContent(isLoading = false)
    }
}

@Preview("Title", showBackground = true, showSystemUi = true)
@Composable
fun HomeTitlePreview() {
    ComposeProjectTheme(darkTheme = false) {
        HomeTitle()
    }
}

@Preview("Title with icon notification", showBackground = true, showSystemUi = true)
@Composable
fun HomeTitleWithNotificationPreview() {
    ComposeProjectTheme(darkTheme = false) {
        HomeTitle(hasNotification = true)
    }
}

@Preview("[Dark] Home content show loading", showBackground = true, showSystemUi = true)
@Composable
fun DarkHomeContentPreview() {
    ComposeProjectTheme(darkTheme = true) {
        HomeContent()
    }
}

@Preview("[Dark] Home content no loading", showBackground = true, showSystemUi = true)
@Composable
fun DarkHomeContentNoLoadingPreview() {
    ComposeProjectTheme(darkTheme = true) {
        HomeContent(isLoading = false)
    }
}

@Preview("[Dark] Title", showBackground = true, showSystemUi = true)
@Composable
fun DarkHomeTitlePreview() {
    ComposeProjectTheme(darkTheme = true) {
        HomeTitle()
    }
}

@Preview("[Dark] Title with icon notification")
@Composable
fun DarkHomeTitleWithNotificationPreview() {
    ComposeProjectTheme(darkTheme = true) {
        HomeTitle(hasNotification = true)
    }
}
