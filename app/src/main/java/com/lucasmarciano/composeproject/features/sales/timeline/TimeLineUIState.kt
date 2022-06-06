package com.lucasmarciano.composeproject.features.sales.timeline

import com.lucasmarciano.composeproject.data.models.TimeLineVO

internal sealed class TimeLineUIState {
    object Loading : TimeLineUIState()
    object ErrorEmpty : TimeLineUIState()
    class Success(val data: List<TimeLineVO>) : TimeLineUIState()
    class Error(val error: Throwable) : TimeLineUIState()
}
