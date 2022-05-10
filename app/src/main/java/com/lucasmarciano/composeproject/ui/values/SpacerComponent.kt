package com.lucasmarciano.composeproject.ui.values

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.ui.Components

internal data class SpacerComponent(
    @SerializedName("horizontal_size")
    val horizontalSize: Int = 0,
    @SerializedName("vertical_size")
    val verticalSize: Int = 0,
) : InterfaceItemComponent(Components.SPACER)
