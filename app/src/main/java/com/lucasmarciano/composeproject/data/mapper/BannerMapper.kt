package com.lucasmarciano.composeproject.data.mapper

import com.lucasmarciano.composeproject.data.models.BannerVO
import com.lucasmarciano.composeproject.data.response.BannerResponse

fun BannerResponse.mapToVO() = BannerVO(
    description = this.description,
    callToAction = this.callToAction.mapToVO(),
)