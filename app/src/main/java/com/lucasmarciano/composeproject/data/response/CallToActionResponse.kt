package com.lucasmarciano.composeproject.data.response

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.core.utils.emptyString

data class CallToActionResponse(
    @SerializedName("name")
    val name: String = emptyString(),
    @SerializedName("segue")
    val action: String = emptyString(),
)
