package com.lucasmarciano.composeproject.features.home

import com.lucasmarciano.composeproject.data.home.models.HomeBuildVO

sealed class HomeUIState {
    object Loading : HomeUIState()
    class Success(val response: HomeBuildVO) : HomeUIState()
    class Error(val error: Throwable) : HomeUIState()
}
