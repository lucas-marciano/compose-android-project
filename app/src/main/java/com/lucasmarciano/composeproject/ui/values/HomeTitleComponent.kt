package com.lucasmarciano.composeproject.ui.values

import com.lucasmarciano.composeproject.ui.Components

internal class HomeTitleComponent(
    val name: String,
    val color: ColorComponent = ColorComponent.PRIMARY,
    val hasNotification: Boolean = false,
) : InterfaceItem(Components.HOME_TITLE)
