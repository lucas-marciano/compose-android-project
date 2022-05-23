package com.lucasmarciano.composeproject.features.sales.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasmarciano.composeproject.ui.mockspreview.mockListItemTimeLine
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class TimeLineViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<TimeLineUIState>(TimeLineUIState.Loading)
    val uiState: StateFlow<TimeLineUIState> = _uiState

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _uiState.value = TimeLineUIState.Loading
            delay(3000)
            _uiState.value = TimeLineUIState.Success(mockListItemTimeLine())
        }
    }
}
