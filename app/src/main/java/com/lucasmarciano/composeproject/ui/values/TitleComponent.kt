package com.lucasmarciano.composeproject.ui.values

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.ui.Components

internal data class TitleComponent(
    @SerializedName("name")
    val name: String,
    @SerializedName("color")
    val color: ColorComponent = ColorComponent.PRIMARY,
) : InterfaceItemComponent(Components.MAIN_TITLE)
