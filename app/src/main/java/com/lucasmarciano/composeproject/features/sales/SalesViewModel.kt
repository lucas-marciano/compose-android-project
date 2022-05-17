package com.lucasmarciano.composeproject.features.sales

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasmarciano.composeproject.ui.mockspreview.mockSalesResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class SalesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<SalesUIState>(SalesUIState.Loading)
    val uiState: StateFlow<SalesUIState> = _uiState

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _uiState.value = SalesUIState.Loading
            delay(3000)
            _uiState.value = SalesUIState.Success(mockSalesResult())
        }
    }
}
