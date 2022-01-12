package com.lucasmarciano.composeproject.ui.mockspreview

import com.lucasmarciano.composeproject.features.models.CallToAction
import com.lucasmarciano.composeproject.features.models.ItemCardHome
import com.lucasmarciano.composeproject.utils.extensions.emptyString

fun mockItemCard() = ItemCardHome(
    text = "voce nao fez nenhuma venda este mes, bora vender?",
    icon = emptyString(),
    callToAction = CallToAction()
)

fun mockItemCardWithIcon() = ItemCardHome(
    text = "voce nao fez nenhuma venda este mes, bora vender?",
    icon = "um icone",
    callToAction = CallToAction()
)

fun mockListItemCard() = listOf(
    mockItemCard(),
    mockItemCardWithIcon(),
)