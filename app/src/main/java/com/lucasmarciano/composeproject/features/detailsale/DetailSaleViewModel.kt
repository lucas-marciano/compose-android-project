package com.lucasmarciano.composeproject.features.detailsale

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasmarciano.composeproject.ui.mockspreview.mockSailDetailResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailSaleViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<DetailSaleUIState>(DetailSaleUIState.Loading)
    val uiState: StateFlow<DetailSaleUIState> = _uiState

    fun fetchData(saleId: String) {
        viewModelScope.launch {
            _uiState.value = DetailSaleUIState.Loading
            delay(3000)
            _uiState.value = DetailSaleUIState.Success(mockSailDetailResult())
        }
    }
}