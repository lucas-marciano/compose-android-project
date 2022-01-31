package com.lucasmarciano.composeproject.features.home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasmarciano.composeproject.data.models.HomeBuildVO
import com.lucasmarciano.composeproject.ui.mockspreview.mockListItemCard
import com.lucasmarciano.composeproject.ui.mockspreview.mockListSimpleItemCardWithIcon
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private var _uiSate by mutableStateOf(value = HomeUIState())
    val uiSate: State<HomeUIState> = _uiSate

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _uiSate.isLoading = true
            delay(3000)
            _uiSate.response = mockResult()
        }
    }

    private fun mockResult() = HomeBuildVO(
        listBlueCard = mockListItemCard(),
        listSimpleCard = mockListSimpleItemCardWithIcon(),
    )
}
