package com.lucasmarciano.composeproject.features.home

import androidx.compose.runtime.State
import com.lucasmarciano.composeproject.data.models.HomeBuildVO

data class HomeUIState(
    var isLoading: Boolean = true,
    var error: Throwable? = null,
    var response: HomeBuildVO = HomeBuildVO()
) : State<HomeUIState> {
    override val value: HomeUIState
        get() = value.value
}
