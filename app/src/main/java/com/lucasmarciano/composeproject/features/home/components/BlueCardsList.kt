package com.lucasmarciano.composeproject.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.ui.components.BlueCard
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCard
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing


@Composable
fun BlueCardsList(cards: List<ItemCardHomeVO>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)) {
        items(cards) { card ->
            BlueCard(item = card)
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
