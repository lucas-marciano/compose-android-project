package com.lucasmarciano.composeproject.features.sales.timeline

import com.lucasmarciano.composeproject.data.home.models.ResponseBuildVO

sealed class TimeLineUIState {
    object Loading : TimeLineUIState()
    object ErrorEmpty : TimeLineUIState()
    class Success(val data: ResponseBuildVO) : TimeLineUIState()
    class Error(val error: Throwable) : TimeLineUIState()
}
