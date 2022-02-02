package com.lucasmarciano.composeproject.data.home.models

import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class ItemCardHomeVO(
    val text: String,
    val icon: String = emptyString(),
    val callToAction: CallToActionVO,
) {
    fun hasIcon() = icon.isEmpty()
}