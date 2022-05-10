package com.lucasmarciano.composeproject.features.home

import com.lucasmarciano.composeproject.data.home.models.ResponseBuildVO

sealed class HomeUIState {
    object Loading : HomeUIState()
    class Success(val data: ResponseBuildVO) : HomeUIState()
    class Error(val error: Throwable) : HomeUIState()
}
