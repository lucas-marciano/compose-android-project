package com.lucasmarciano.composeproject.data.home.response

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.data.response.CallToActionResponse
import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class ItemCardHomeResponse(
    @SerializedName("main_title")
    val text: String,
    @SerializedName("icon")
    val icon: String = emptyString(),
    @SerializedName("call_to_action")
    val callToAction: CallToActionResponse,
)
