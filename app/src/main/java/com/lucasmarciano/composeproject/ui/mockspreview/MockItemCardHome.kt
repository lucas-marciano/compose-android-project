package com.lucasmarciano.composeproject.ui.mockspreview

import com.lucasmarciano.composeproject.data.home.models.BannerVO
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.data.home.models.ResponseBuildVO
import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.data.models.HeaderTimeLineVO
import com.lucasmarciano.composeproject.data.models.ItemTimeLineVO
import com.lucasmarciano.composeproject.data.models.ProfileVO
import com.lucasmarciano.composeproject.data.models.SalesInformationVO
import com.lucasmarciano.composeproject.data.models.TimeLineVO
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
import kotlin.random.Random

internal fun mockBanner() = BannerVO(
    description = "que tal uma maquininha pra\naceitar cartões de crédito? :D",
    callToAction = CallToActionVO(
        name = "pedir maquininha",
        action = ""
    )
)

internal fun mockItemCard() = ItemCardHomeVO(
    id = Random.nextInt(),
    text = "você não fez nenhuma venda este mês, bora vender?",
    icon = emptyString(),
    callToAction = CallToActionVO(action = "sales_screen_route")
)

internal fun mockItemCardWithIcon() = ItemCardHomeVO(
    id = Random.nextInt(),
    text = "você não fez nenhuma venda este mês, bora vender?",
    icon = "um icone",
    callToAction = CallToActionVO()
)

internal fun mockSimpleItemCardWithIcon() = ItemCardHomeVO(
    id = Random.nextInt(),
    text = "sell",
    icon = "um icone",
    callToAction = CallToActionVO()
)

internal fun mockListSimpleItemCardWithIcon() = listOf(
    ItemCardHomeVO(
        id = Random.nextInt(),
        text = "pix",
        icon = "um icone",
        callToAction = CallToActionVO()
    ),
    ItemCardHomeVO(
        id = Random.nextInt(),
        text = "cartão",
        icon = "um icone",
        callToAction = CallToActionVO()
    ),
)

internal fun mockListItemCard() = listOf(
    mockItemCard(),
    mockItemCardWithIcon(),
)

internal fun mockSailDetailResult() = ResponseBuildVO(
    listItems = listOf(
        ToolbarComponent(
            title = "detalhe de venda",
        ),
        SpacerComponent(verticalSize = 16),
        //TODO("card detail")
        SpacerComponent(verticalSize = 16),
        //TODO("card payment")
        SpacerComponent(verticalSize = 16),
        //TODO("botao sem linha")
        SpacerComponent(verticalSize = 8),
        //TODO("botao")
    )
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

internal fun mockSalesResult() = SalesInformationVO(
    "seu negócio",
    "suas vendas totais",
    "R$ 1234,56",
    "gold_coin"
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

internal fun mockListTimeLine() = listOf(
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 1", "info 1")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 2", "info 2")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 3", "info 3")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 4", "info 4")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 5", "info 5")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 6", "info 6")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 7", "info 7")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 8", "info 8")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 9", "info 9")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 10", "info 10")),
    mockTimeLine().copy(headerTimeLineVO = HeaderTimeLineVO("item 11", "info 11")),
)

internal fun mockTimeLine() = TimeLineVO(
    HeaderTimeLineVO(
        "title", "info"
    ),
    mockListItemTimeLine()
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
    mockItemTimeLine(),
    mockItemTimeLine()
)

internal fun mockItemTimeLine() = ItemTimeLineVO(
    position = Random.nextInt(),
    id = Random.nextInt().toString(),
    icon = "",
    title = "pagamento pix",
    value = "R$ ${Random.nextInt(10, 100)},00",
    description = "pagamento via pix",
    tag = "pix",
    callToActionVO = CallToActionVO(
        "",
        action = "sell/detail/{sellId}"
    )
)
