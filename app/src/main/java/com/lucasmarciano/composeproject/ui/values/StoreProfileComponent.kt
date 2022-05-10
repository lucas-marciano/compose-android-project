package com.lucasmarciano.composeproject.ui.values

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.data.settings.models.StoreNameVO
import com.lucasmarciano.composeproject.ui.Components

internal data class StoreProfileComponent(
    @SerializedName("store")
    val store: StoreNameVO
) : InterfaceItemComponent(Components.STORE_PROFILE)