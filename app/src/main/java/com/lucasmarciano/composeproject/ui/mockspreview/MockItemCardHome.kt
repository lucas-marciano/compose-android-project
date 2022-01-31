package com.lucasmarciano.composeproject.ui.mockspreview

import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.data.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.utils.extensions.emptyString

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
