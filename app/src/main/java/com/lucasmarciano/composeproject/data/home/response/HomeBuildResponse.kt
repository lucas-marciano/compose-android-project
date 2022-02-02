package com.lucasmarciano.composeproject.data.home.response

import com.google.gson.annotations.SerializedName
import com.lucasmarciano.composeproject.data.response.BannerResponse

data class HomeBuildResponse(
    @SerializedName("list_main_cards")
    val listBlueCard: List<ItemCardHomeResponse> = emptyList(),
    @SerializedName("list_secondary_cards")
    val listSimpleCard: List<ItemCardHomeResponse> = emptyList(),
    @SerializedName("banner_info")
    val bannerInfo: BannerResponse? = null,
)
