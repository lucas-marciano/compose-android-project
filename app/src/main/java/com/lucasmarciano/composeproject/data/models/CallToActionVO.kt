package com.lucasmarciano.composeproject.data.models

import com.lucasmarciano.core.utils.emptyString

data class CallToActionVO(
    val name: String = emptyString(),
    val action: String = emptyString(),
    val onClick: () -> Unit = {}
)
