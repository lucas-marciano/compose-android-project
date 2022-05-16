package com.lucasmarciano.composeproject.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.ui.components.BlueCard
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCard
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing
import com.lucasmarciano.composeproject.utils.extensions.navTo

@Composable
fun BlueCardsList(
    cards: List<ItemCardHomeVO>,
    navController: NavController = rememberNavController(),
) {
    LazyRow(
        state = rememberLazyListState(),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
    ) {
        items(cards, key = { it.id }) { card ->
            BlueCard(item = card) { navController.navTo(card.callToAction.action) }
        }
    }
}

@Preview("Blue Card list")
@Composable
fun BlueCardListPreview() {
    ComposeProjectTheme(darkTheme = false) {
        BlueCardsList(
            listOf(mockItemCard(), mockItemCard())
        )
    }
}
