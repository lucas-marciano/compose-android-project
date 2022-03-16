package com.lucasmarciano.composeproject.data.home.models

import com.lucasmarciano.composeproject.data.models.BannerVO
import com.lucasmarciano.composeproject.ui.values.InterfaceItem

data class HomeBuildVO(
    val listBlueCard: List<ItemCardHomeVO> = emptyList(),
    val listSimpleCard: List<ItemCardHomeVO> = emptyList(),
    val bannerInfo: BannerVO? = null,
    val listItems: List<InterfaceItem> = emptyList(),
)
