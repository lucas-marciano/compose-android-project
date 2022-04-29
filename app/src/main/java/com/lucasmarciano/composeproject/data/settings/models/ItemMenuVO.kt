package com.lucasmarciano.composeproject.data.settings.models

import com.lucasmarciano.composeproject.data.models.CallToActionVO

internal data class ItemMenuVO(
    val icon: String,
    val callToActionVO: CallToActionVO
)