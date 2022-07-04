package com.lucasmarciano.composeproject.data.home.models

import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.core.utils.emptyString

internal data class BannerVO(
    val description: String = emptyString(),
    val callToAction: CallToActionVO = CallToActionVO()
)