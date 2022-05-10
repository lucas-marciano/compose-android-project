package com.lucasmarciano.composeproject.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.ui.components.CardWithIcon
import com.lucasmarciano.composeproject.ui.mockspreview.mockListSimpleItemCardWithIcon
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing

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

@Preview("Card list")
@Composable
fun CardListPreview() {
    ComposeProjectTheme(darkTheme = false) {
        CardsList(mockListSimpleItemCardWithIcon())
    }
}
