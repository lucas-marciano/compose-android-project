package com.lucasmarciano.composeproject.ui.mockspreview

import com.lucasmarciano.composeproject.features.models.CallToAction
import com.lucasmarciano.composeproject.features.models.ItemCardHome
import com.lucasmarciano.composeproject.utils.extensions.emptyString

fun mockItemCard() = ItemCardHome(
    text = "você não fez nenhuma venda este mês, bora vender?",
    icon = emptyString(),
    callToAction = CallToAction()
)

fun mockItemCardWithIcon() = ItemCardHome(
    text = "você não fez nenhuma venda este mês, bora vender?",
    icon = "um icone",
    callToAction = CallToAction()
)

fun mockListItemCard() = listOf(
    mockItemCard(),
    mockItemCardWithIcon(),
)