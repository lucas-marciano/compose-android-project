package com.lucasmarciano.composeproject.data.models

import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class BannerVO(
    val description: String = emptyString(),
    val callToAction: CallToActionVO = CallToActionVO()
)