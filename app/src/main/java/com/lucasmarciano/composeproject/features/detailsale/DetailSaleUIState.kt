package com.lucasmarciano.composeproject.features.detailsale

import com.lucasmarciano.composeproject.data.home.models.ResponseBuildVO

sealed class DetailSaleUIState {
    object Loading : DetailSaleUIState()
    class Success(val data: ResponseBuildVO) : DetailSaleUIState()
    class Error(val error: Throwable) : DetailSaleUIState()
}
