package com.lucasmarciano.composeproject.features.sales.header

import com.lucasmarciano.composeproject.data.home.models.ResponseBuildVO

sealed class HeaderSalesUIState {
    object Loading : HeaderSalesUIState()
    class Success(val data: ResponseBuildVO) : HeaderSalesUIState()
    class Error(val error: Throwable) : HeaderSalesUIState()
}
