package com.lucasmarciano.composeproject.features.sales

import com.lucasmarciano.composeproject.data.home.models.ResponseBuildVO

sealed class SalesUIState {
    object Loading : SalesUIState()
    class Success(val data: ResponseBuildVO) : SalesUIState()
    class Error(val error: Throwable) : SalesUIState()
}