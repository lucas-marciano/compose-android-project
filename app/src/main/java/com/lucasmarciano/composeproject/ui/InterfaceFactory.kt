package com.lucasmarciano.composeproject.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.lucasmarciano.composeproject.features.home.components.BlueCardsList
import com.lucasmarciano.composeproject.features.home.components.CardsList
import com.lucasmarciano.composeproject.features.home.components.HomeTitle
import com.lucasmarciano.composeproject.ui.components.Banner
import com.lucasmarciano.composeproject.ui.components.SecondTitle
import com.lucasmarciano.composeproject.ui.components.Title
import com.lucasmarciano.composeproject.ui.theme.ColorBlueCard
import com.lucasmarciano.composeproject.ui.theme.ColorPinkCalifornia
import com.lucasmarciano.composeproject.ui.values.BannerComponent
import com.lucasmarciano.composeproject.ui.values.CardBlueListComponent
import com.lucasmarciano.composeproject.ui.values.CardIconListComponent
import com.lucasmarciano.composeproject.ui.values.ColorComponent
import com.lucasmarciano.composeproject.ui.values.HomeTitleComponent
import com.lucasmarciano.composeproject.ui.values.InterfaceItemVO
import com.lucasmarciano.composeproject.ui.values.SecondTitleComponent
import com.lucasmarciano.composeproject.ui.values.SpacerComponent
import com.lucasmarciano.composeproject.ui.values.TitleComponent

@Composable
fun InterfaceFactory(listItems: List<InterfaceItemVO>) {
    listItems.forEach { item ->
        when (item.typeComponent) {
            Components.HOME_TITLE -> {
                val homeValue = (item as HomeTitleComponent)
                HomeTitle(homeValue.name, homeValue.hasNotification)
            }
            Components.MAIN_TITLE -> {
                val homeValue = (item as TitleComponent)
                Title(homeValue.name, composeColorValue(homeValue.color))
            }
            Components.SECOND_TITLE -> {
                val secondTitle = (item as SecondTitleComponent)
                SecondTitle(secondTitle.name, composeColorValue(secondTitle.color))
            }
            Components.CARD_ICON_LIST -> {
                val cardIconList = (item as CardIconListComponent).items
                CardsList(cardIconList)
            }
            Components.CARD_BLUE_LIST -> {
                val cardList = (item as CardBlueListComponent).items
                BlueCardsList(cardList)
            }
            Components.SPACER -> {
                val spacerComponent = (item as SpacerComponent)
                Spacer(
                    modifier = Modifier
                        .height(composeDimensionValue(spacerComponent.verticalSize))
                        .width(composeDimensionValue(spacerComponent.horizontalSize))
                )
            }
            Components.BANNER -> {
                val bannerComponent = (item as BannerComponent)
                Banner(bannerComponent.item)
            }
        }
    }
}

@Composable
private fun composeColorValue(colorComponent: ColorComponent): Color {
    return when (colorComponent) {
        ColorComponent.PINK -> ColorPinkCalifornia
        ColorComponent.BLUE_CARD_BG -> ColorBlueCard
        ColorComponent.BACKGROUND -> MaterialTheme.colors.background
        ColorComponent.SECONDARY -> MaterialTheme.colors.secondary
        ColorComponent.SURFACE -> MaterialTheme.colors.surface
        ColorComponent.ON_PRIMARY -> MaterialTheme.colors.onPrimary
        ColorComponent.ON_SECONDARY -> MaterialTheme.colors.onSecondary
        ColorComponent.ON_BACKGROUND -> MaterialTheme.colors.onBackground
        ColorComponent.ON_SURFACE -> MaterialTheme.colors.onSurface
        else -> MaterialTheme.colors.primary
    }
}

@Composable
private fun composeDimensionValue(dimen: Int) = LocalDensity.current.run { dimen.toDp() }