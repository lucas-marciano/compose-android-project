package com.lucasmarciano.composeproject.ui.mockspreview

import com.lucasmarciano.composeproject.data.home.models.BannerVO
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.data.home.models.ResponseBuildVO
import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.data.models.ItemTimeLineVO
import com.lucasmarciano.composeproject.data.models.ProfileVO
import com.lucasmarciano.composeproject.data.settings.models.ItemMenuVO
import com.lucasmarciano.composeproject.data.settings.models.StoreNameVO
import com.lucasmarciano.composeproject.ui.values.BannerComponent
import com.lucasmarciano.composeproject.ui.values.CardBlueListComponent
import com.lucasmarciano.composeproject.ui.values.CardIconListComponent
import com.lucasmarciano.composeproject.ui.values.ColorComponent
import com.lucasmarciano.composeproject.ui.values.HomeTitleComponent
import com.lucasmarciano.composeproject.ui.values.MenuItemComponent
import com.lucasmarciano.composeproject.ui.values.SecondTitleComponent
import com.lucasmarciano.composeproject.ui.values.SpacerComponent
import com.lucasmarciano.composeproject.ui.values.StoreProfileComponent
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent
import com.lucasmarciano.composeproject.utils.extensions.emptyString

internal fun mockBanner() = BannerVO(
    description = "que tal uma maquininha pra\naceitar cartões de crédito? :D",
    callToAction = CallToActionVO(
        name = "pedir maquininha",
        action = ""
    )
)

internal fun mockItemCard() = ItemCardHomeVO(
    id = 0,
    text = "você não fez nenhuma venda este mês, bora vender?",
    icon = emptyString(),
    callToAction = CallToActionVO()
)

internal fun mockItemCardWithIcon() = ItemCardHomeVO(
    id = 0,
    text = "você não fez nenhuma venda este mês, bora vender?",
    icon = "um icone",
    callToAction = CallToActionVO()
)

internal fun mockSimpleItemCardWithIcon() = ItemCardHomeVO(
    id = 0,
    text = "sell",
    icon = "um icone",
    callToAction = CallToActionVO()
)

internal fun mockListSimpleItemCardWithIcon() = listOf(
    ItemCardHomeVO(
        id = 0,
        text = "pix",
        icon = "um icone",
        callToAction = CallToActionVO()
    ),
    ItemCardHomeVO(
        id = 1,
        text = "cartão",
        icon = "um icone",
        callToAction = CallToActionVO()
    ),
)

internal fun mockListItemCard() = listOf(
    mockItemCard(),
    mockItemCardWithIcon(),
)

internal fun mockHomeResult() = ResponseBuildVO(
    listItems = listOf(
        ToolbarComponent(
            title = "seu negócio",
        ),
        HomeTitleComponent(
            name = "teste negocio",
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
            name = "banners",
            color = ColorComponent.ON_BACKGROUND
        ),
        BannerComponent(
            item = mockBanner()
        ),
        SpacerComponent(verticalSize = 16),
    )
)

internal fun mockSettingsResult() = ResponseBuildVO(
    listItems = listOf(
        ToolbarComponent(
            title = "configurações",
        ),
        StoreProfileComponent(
            StoreNameVO(
                mockProfile(),
                emptyString()
            )
        ),
        MenuItemComponent(
            mockItemMenuList()
        )
    )
)

internal fun mockProfile() = listOf(
    ProfileVO(
        callToActionVO = CallToActionVO(name = "editar", action = "action"),
        name = "Loja Teste",
        title = "Nome da loja"
    )
)

internal fun mockProfileNonCallToAction() = listOf(
    ProfileVO(
        callToActionVO = CallToActionVO(),
        name = "Loja Teste",
        title = "Nome da loja"
    )
)

internal fun mockTwoProfile() = listOf(
    ProfileVO(
        callToActionVO = CallToActionVO(name = "editar", action = "action"),
        name = "Loja Teste",
        title = "Nome da loja"
    ),
    ProfileVO(
        callToActionVO = CallToActionVO(name = "editar", action = "action"),
        name = "Segunda loja",
        title = "Segundo nome da loja"
    )
)

internal fun mockTwoProfileNonAction() = listOf(
    ProfileVO(
        callToActionVO = CallToActionVO(),
        name = "Loja Teste",
        title = "Nome da loja"
    ),
    ProfileVO(
        callToActionVO = CallToActionVO(),
        name = "Segunda loja",
        title = "Segundo nome da loja"
    )
)

internal fun mockItemMenu() = ItemMenuVO(
    icon = "icon",
    callToActionVO = CallToActionVO(
        name = "menu 1"
    )
)

internal fun mockItemMenuList() = listOf(
    ItemMenuVO(
        icon = "icon",
        callToActionVO = CallToActionVO(
            name = "menu 1"
        )
    ),
    ItemMenuVO(
        icon = "icon",
        callToActionVO = CallToActionVO(
            name = "menu 2"
        )
    ), ItemMenuVO(
        icon = "icon",
        callToActionVO = CallToActionVO(
            name = "menu 3"
        )
    ), ItemMenuVO(
        icon = "icon",
        callToActionVO = CallToActionVO(
            name = "menu 4"
        )
    )
)

internal fun mockListItemTimeLine() = listOf(
    mockItemTimeLine(),
    mockItemTimeLine(),
    mockItemTimeLine(),
    mockItemTimeLine(),
    mockItemTimeLine(),
    mockItemTimeLine(),
    mockItemTimeLine(),
    mockItemTimeLine(),
    mockItemTimeLine()
)

internal fun mockItemTimeLine() = ItemTimeLineVO(
    position = 1,
    id = "1",
    icon = "",
    title = "pagamento pix",
    value = "R$ 100,00",
    description = "pagamento via pix",
    tag = "pix",
    callToActionVO = CallToActionVO(
        "",
        action = "sell/detail/{sellId}"
    )
)
