package com.lucasmarciano.composeproject.ui.mockspreview

import com.lucasmarciano.composeproject.data.models.BannerVO
import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.data.models.HomeBuildVO
import com.lucasmarciano.composeproject.data.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.features.home.HomeUIState
import com.lucasmarciano.composeproject.utils.extensions.emptyString
import kotlinx.coroutines.flow.MutableStateFlow

fun mockBanner() = BannerVO(
    description = "que tal uma maquininha pra\naceitar cartões de crédito? :D",
    callToAction = CallToActionVO(
        name = "pedir maquininha",
        action = ""
    )
)

fun mockItemCard() = ItemCardHomeVO(
    text = "você não fez nenhuma venda este mês, bora vender?",
    icon = emptyString(),
    callToActionVO = CallToActionVO()
)

fun mockItemCardWithIcon() = ItemCardHomeVO(
    text = "você não fez nenhuma venda este mês, bora vender?",
    icon = "um icone",
    callToActionVO = CallToActionVO()
)

fun mockSimpleItemCardWithIcon() = ItemCardHomeVO(
    text = "sell",
    icon = "um icone",
    callToActionVO = CallToActionVO()
)

fun mockListSimpleItemCardWithIcon() = listOf(
    ItemCardHomeVO(
        text = "pix",
        icon = "um icone",
        callToActionVO = CallToActionVO()
    ),
    ItemCardHomeVO(
        text = "cartão",
        icon = "um icone",
        callToActionVO = CallToActionVO()
    ),
)

fun mockListItemCard() = listOf(
    mockItemCard(),
    mockItemCardWithIcon(),
)

fun mockHomeUIState(): HomeUIState {
    val uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    uiState.value = HomeUIState.Success(mockResult())
    return uiState.value
}

fun mockHomeUIStateWithLoading(): HomeUIState {
    val uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    return uiState.value
}

fun mockResult() = HomeBuildVO(
    listBlueCard = mockListItemCard(),
    listSimpleCard = mockListSimpleItemCardWithIcon(),
    bannerInfo = mockBanner()
)
