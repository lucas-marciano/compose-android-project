package com.lucasmarciano.composeproject.features.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasmarciano.composeproject.ui.mockspreview.mockSettingsResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<SettingsUIState>(SettingsUIState.Loading)
    val uiState: StateFlow<SettingsUIState> = _uiState

    fun fetchData() {
        viewModelScope.launch {
            _uiState.value = SettingsUIState.Loading
            delay(3000)
            _uiState.value = SettingsUIState.Success(mockSettingsResult())
        }
    }
}
