package com.lucasmarciano.composeproject.features.settings

import com.lucasmarciano.composeproject.data.home.models.ResponseBuildVO

sealed class SettingsUIState {
    object Loading : SettingsUIState()
    class Success(val data: ResponseBuildVO) : SettingsUIState()
    class Error(val error: Throwable) : SettingsUIState()
}
