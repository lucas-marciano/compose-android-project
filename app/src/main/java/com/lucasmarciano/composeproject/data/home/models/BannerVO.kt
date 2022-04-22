package com.lucasmarciano.composeproject.data.home.models

import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class BannerVO(
    val description: String = emptyString(),
    val callToAction: CallToActionVO = CallToActionVO()
)