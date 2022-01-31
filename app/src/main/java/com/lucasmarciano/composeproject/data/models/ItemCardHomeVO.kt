package com.lucasmarciano.composeproject.data.models

import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class ItemCardHomeVO(
    val text: String,
    val icon: String = emptyString(),
    val callToActionVO: CallToActionVO,
) {
    fun hasIcon() = icon.isEmpty()
}