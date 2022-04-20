package com.lucasmarciano.composeproject.data.home.response

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.ui.values.InterfaceItemVO

data class HomeBuildResponse(
    @SerializedName("list_items")
    val listItems: List<InterfaceItemVO> = emptyList(),
)
