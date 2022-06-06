package com.lucasmarciano.composeproject.data.models

internal data class TimeLineVO(
    val headerTimeLineVO: HeaderTimeLineVO,
    val list: List<ItemTimeLineVO> = emptyList()
)