package com.lucasmarciano.composeproject.data.response

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.utils.extensions.emptyString

data class BannerResponse(
    @SerializedName("banner_description")
    val description: String = emptyString(),
    @SerializedName("call_to_action")
    val callToAction: CallToActionResponse = CallToActionResponse()
)