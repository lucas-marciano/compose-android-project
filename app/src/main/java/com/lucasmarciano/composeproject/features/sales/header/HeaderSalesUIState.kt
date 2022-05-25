package com.lucasmarciano.composeproject.features.sales.header

import com.lucasmarciano.composeproject.data.models.SalesInformationVO

sealed class HeaderSalesUIState {
    object Loading : HeaderSalesUIState()
    class Success(val data: SalesInformationVO) : HeaderSalesUIState()
    class Error(val error: Throwable) : HeaderSalesUIState()
}
