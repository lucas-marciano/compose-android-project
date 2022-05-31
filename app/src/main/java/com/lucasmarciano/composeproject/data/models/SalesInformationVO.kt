package com.lucasmarciano.composeproject.data.models

import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class SalesInformationVO(
    val title: String = emptyString(),
    val subtitle: String = emptyString(),
    val value: String = emptyString(),
    val icon: String = emptyString(),
)
