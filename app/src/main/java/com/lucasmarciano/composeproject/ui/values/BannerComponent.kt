package com.lucasmarciano.composeproject.ui.values

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.data.home.models.BannerVO
import com.lucasmarciano.composeproject.ui.Components

internal class BannerComponent(
    @SerializedName("item")
    val item: BannerVO? = null,
) : InterfaceItemComponent(Components.BANNER)
