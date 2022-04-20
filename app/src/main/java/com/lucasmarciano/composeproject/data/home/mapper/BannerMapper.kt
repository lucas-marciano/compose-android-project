package com.lucasmarciano.composeproject.data.home.mapper

import com.lucasmarciano.composeproject.data.home.models.BannerVO
import com.lucasmarciano.composeproject.data.home.response.BannerResponse
import com.lucasmarciano.composeproject.data.mapper.mapToVO

fun BannerResponse.mapToVO() = BannerVO(
    description = this.description,
    callToAction = this.callToAction.mapToVO(),
)