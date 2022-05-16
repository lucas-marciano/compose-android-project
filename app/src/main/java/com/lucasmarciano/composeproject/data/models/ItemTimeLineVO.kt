package com.lucasmarciano.composeproject.data.models

internal data class ItemTimeLineVO(
    val position: Int,
    val id: String,
    val icon: String,
    val title: String,
    val value: String,
    val description: String,
    val tag: String,
    val tagType: ChipType = ChipType.INFO,
    val callToActionVO: CallToActionVO
)

internal enum class ChipType {
    ERROR,
    INFO
}
