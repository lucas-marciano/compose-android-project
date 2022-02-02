package com.lucasmarciano.composeproject.data.home.mapper

import com.lucasmarciano.composeproject.data.home.models.HomeBuildVO
import com.lucasmarciano.composeproject.data.home.response.HomeBuildResponse
import com.lucasmarciano.composeproject.data.mapper.mapToVO

fun HomeBuildResponse.mapToVO() = HomeBuildVO(
    listBlueCard = this.listBlueCard.mapToVO(),
    listSimpleCard = this.listSimpleCard.mapToVO(),
    bannerInfo = this.bannerInfo?.mapToVO(),
)
