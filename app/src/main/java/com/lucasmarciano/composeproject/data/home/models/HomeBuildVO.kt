package com.lucasmarciano.composeproject.data.home.models

import com.lucasmarciano.composeproject.data.models.BannerVO

data class HomeBuildVO(
    val listBlueCard: List<ItemCardHomeVO> = emptyList(),
    val listSimpleCard: List<ItemCardHomeVO> = emptyList(),
    val bannerInfo: BannerVO? = null,
)
