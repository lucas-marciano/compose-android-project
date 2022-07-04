@file:OptIn(ExperimentalAnimationApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.lucasmarciano.composeproject.features.home.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.ui.components.BlueCard
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCard
import com.lucasmarciano.composeproject.utils.extensions.navTo
import com.lucasmarciano.iti_module.ItiTheme

@Composable
fun BlueCardsList(
    cards: List<ItemCardHomeVO>,
    navController: NavController = rememberAnimatedNavController(),
) {
    LazyRow(
        state = rememberLazyListState(),
        horizontalArrangement = Arrangement.spacedBy(ItiTheme.spacing.small)
    ) {
        items(cards, key = { it.id }) { card ->
            BlueCard(item = card) { navController.navTo(card.callToAction.action) }
        }
    }
}

@Preview("Blue Card list")
@Composable
fun BlueCardListPreview() {
    ItiTheme(darkTheme = false) {
        BlueCardsList(
            listOf(mockItemCard(), mockItemCard())
        )
    }
}
