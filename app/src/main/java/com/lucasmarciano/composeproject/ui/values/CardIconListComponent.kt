package com.lucasmarciano.composeproject.ui.values

import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.ui.Components

internal class CardIconListComponent(
    val items: List<ItemCardHomeVO> = emptyList()
) : InterfaceItem(Components.CARD_ICON_LIST)
