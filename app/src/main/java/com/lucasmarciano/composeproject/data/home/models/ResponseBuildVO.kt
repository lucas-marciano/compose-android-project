package com.lucasmarciano.composeproject.data.home.models

import com.lucasmarciano.composeproject.ui.values.InterfaceItemVO

data class ResponseBuildVO(
    val listItems: List<InterfaceItemVO> = emptyList(),
)
