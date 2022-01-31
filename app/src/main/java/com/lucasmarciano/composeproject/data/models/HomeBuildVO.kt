package com.lucasmarciano.composeproject.data.models

data class HomeBuildVO(
    val listBlueCard: List<ItemCardHomeVO> = emptyList(),
    val listSimpleCard: List<ItemCardHomeVO> = emptyList(),
)