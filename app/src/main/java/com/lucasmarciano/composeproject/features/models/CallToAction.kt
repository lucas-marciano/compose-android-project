package com.lucasmarciano.composeproject.features.models

import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class CallToAction(
    val name: String = emptyString(),
    val action: String = emptyString(),
)
