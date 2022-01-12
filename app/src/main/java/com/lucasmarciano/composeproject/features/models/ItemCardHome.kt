package com.lucasmarciano.composeproject.features.models

import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class ItemCardHome(
    val text: String,
    val icon: String = emptyString(),
    val callToAction: CallToAction,
) {
    fun hasIcon() = icon.isEmpty()
}