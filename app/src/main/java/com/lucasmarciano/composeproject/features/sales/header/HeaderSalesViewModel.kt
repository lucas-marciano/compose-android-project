package com.lucasmarciano.composeproject.features.sales.header

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasmarciano.composeproject.ui.mockspreview.mockSalesResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class HeaderSalesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<HeaderSalesUIState>(HeaderSalesUIState.Loading)
    val uiState: StateFlow<HeaderSalesUIState> = _uiState

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _uiState.value = HeaderSalesUIState.Loading
            delay(3000)
            _uiState.value = HeaderSalesUIState.Success(mockSalesResult())
        }
    }
}
