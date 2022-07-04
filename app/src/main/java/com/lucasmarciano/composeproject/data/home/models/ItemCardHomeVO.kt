package com.lucasmarciano.composeproject.data.home.models

import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.core.utils.emptyString

data class ItemCardHomeVO(
    val id: Int,
    val text: String,
    val icon: String = emptyString(),
    val callToAction: CallToActionVO,
) {
    fun hasIcon() = icon.isEmpty()
}