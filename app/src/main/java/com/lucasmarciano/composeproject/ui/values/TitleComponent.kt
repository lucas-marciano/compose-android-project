package com.lucasmarciano.composeproject.ui.values

import com.lucasmarciano.composeproject.ui.Components

internal class TitleComponent(
    val name: String,
    val color: ColorComponent = ColorComponent.PRIMARY,
) : InterfaceItem(Components.MAIN_TITLE)
