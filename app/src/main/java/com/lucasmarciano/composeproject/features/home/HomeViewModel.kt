package com.lucasmarciano.composeproject.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasmarciano.composeproject.ui.mockspreview.mockResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val uiState: StateFlow<HomeUIState> = _uiState

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _uiState.value = HomeUIState.Loading
            delay(3000)
            _uiState.value = HomeUIState.Success(mockResult())
        }
    }
}
