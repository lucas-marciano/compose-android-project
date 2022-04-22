package com.lucasmarciano.composeproject.data.home.mapper

import com.lucasmarciano.composeproject.data.home.models.HomeBuildVO
import com.lucasmarciano.composeproject.data.home.response.HomeBuildResponse

fun HomeBuildResponse.mapToVO() = HomeBuildVO(
    listItems = this.listItems
)
