package com.lucasmarciano.composeproject.data.models

import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class CallToActionVO(
    val name: String = emptyString(),
    val action: String = emptyString(),
)
