package com.lucasmarciano.composeproject.data.settings.models

import com.lucasmarciano.composeproject.data.models.ProfileVO

internal data class StoreNameVO(
    val profile: List<ProfileVO> = emptyList(),
    val avatar: String,
)
