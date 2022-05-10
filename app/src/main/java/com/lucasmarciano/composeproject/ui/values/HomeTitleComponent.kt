package com.lucasmarciano.composeproject.ui.values

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.ui.Components

internal data class HomeTitleComponent(
    @SerializedName("name")
    val name: String,
    @SerializedName("color")
    val color: ColorComponent = ColorComponent.PRIMARY,
    @SerializedName("has_notification")
    val hasNotification: Boolean = false,
) : InterfaceItemComponent(Components.HOME_TITLE)
