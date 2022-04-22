package com.lucasmarciano.composeproject.ui.values

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.ui.Components

internal class SecondTitleComponent(
    @SerializedName("name")
    val name: String,
    @SerializedName("color")
    val color: ColorComponent = ColorComponent.PRIMARY,
) : InterfaceItemVO(Components.SECOND_TITLE)
