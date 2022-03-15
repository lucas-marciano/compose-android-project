package com.lucasmarciano.composeproject.ui.values

import com.lucasmarciano.composeproject.ui.Components

internal class SecondTitleComponent(
    val name: String,
    val color: ColorComponent = ColorComponent.PRIMARY,
) : InterfaceItem(Components.SECOND_TITLE)
