package com.lucasmarciano.composeproject.ui.values

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.data.settings.models.ItemMenuVO
import com.lucasmarciano.composeproject.ui.Components

internal data class MenuItemComponent (
    @SerializedName("buttons")
    val buttons: List<ItemMenuVO>
): InterfaceItemComponent(Components.MENU_SETTINGS)