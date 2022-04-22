package com.lucasmarciano.composeproject.ui.values

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.ui.Components

internal class CardBlueListComponent(
    @SerializedName("items")
    val items: List<ItemCardHomeVO> = emptyList()
) : InterfaceItemVO(Components.CARD_BLUE_LIST)