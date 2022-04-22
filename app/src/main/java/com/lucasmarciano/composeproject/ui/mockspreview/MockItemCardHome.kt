package com.lucasmarciano.composeproject.ui.mockspreview

import com.lucasmarciano.composeproject.data.home.models.BannerVO
import com.lucasmarciano.composeproject.data.home.models.HomeBuildVO
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.ui.values.BannerComponent
import com.lucasmarciano.composeproject.ui.values.CardBlueListComponent
import com.lucasmarciano.composeproject.ui.values.CardIconListComponent
import com.lucasmarciano.composeproject.ui.values.ColorComponent
import com.lucasmarciano.composeproject.ui.values.HomeTitleComponent
import com.lucasmarciano.composeproject.ui.values.SecondTitleComponent
import com.lucasmarciano.composeproject.ui.values.SpacerComponent
import com.lucasmarciano.composeproject.utils.extensions.emptyString

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
    callToAction = CallToActionVO()
)

fun mockItemCardWithIcon() = ItemCardHomeVO(
    text = "você não fez nenhuma venda este mês, bora vender?",
    icon = "um icone",
    callToAction = CallToActionVO()
)

fun mockSimpleItemCardWithIcon() = ItemCardHomeVO(
    text = "sell",
    icon = "um icone",
    callToAction = CallToActionVO()
)

fun mockListSimpleItemCardWithIcon() = listOf(
    ItemCardHomeVO(
        text = "pix",
        icon = "um icone",
        callToAction = CallToActionVO()
    ),
    ItemCardHomeVO(
        text = "cartão",
        icon = "um icone",
        callToAction = CallToActionVO()
    ),
)

fun mockListItemCard() = listOf(
    mockItemCard(),
    mockItemCardWithIcon(),
)

fun mockResult() = HomeBuildVO(
    listItems = listOf(
        HomeTitleComponent(
            name = "seu negócio online",
            color = ColorComponent.ON_BACKGROUND,
            hasNotification = true
        ),
        SpacerComponent(verticalSize = 16),
        CardBlueListComponent(
            items = mockListItemCard()
        ),
        SpacerComponent(verticalSize = 16),
        SecondTitleComponent(
            name = "vender",
            color = ColorComponent.ON_BACKGROUND
        ),
        CardIconListComponent(
            items = mockListSimpleItemCardWithIcon()
        ),
        SpacerComponent(verticalSize = 16),
        SecondTitleComponent(
            name = "vender",
            color = ColorComponent.ON_BACKGROUND
        ),
        BannerComponent(
            item = mockBanner()
        )
    )
)
