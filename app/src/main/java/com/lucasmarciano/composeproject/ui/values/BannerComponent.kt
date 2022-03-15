package com.lucasmarciano.composeproject.ui.values

import com.lucasmarciano.composeproject.data.models.BannerVO
import com.lucasmarciano.composeproject.ui.Components

internal class BannerComponent(
    val item: BannerVO? = null,
) : InterfaceItem(Components.BANNER)
