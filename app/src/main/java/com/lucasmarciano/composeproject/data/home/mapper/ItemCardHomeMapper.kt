package com.lucasmarciano.composeproject.data.home.mapper

import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.data.home.response.ItemCardHomeResponse
import com.lucasmarciano.composeproject.data.mapper.mapToVO

fun ItemCardHomeResponse.mapToVO() = ItemCardHomeVO(
    text = this.text,
    icon = this.icon,
    callToAction = this.callToAction.mapToVO(),
)

fun List<ItemCardHomeResponse>.mapToVO() = this.map { it.mapToVO() }
