package com.lucasmarciano.composeproject.data.models

import androidx.compose.ui.graphics.Color
import com.lucasmarciano.composeproject.ui.theme.ColorBlueCard
import com.lucasmarciano.composeproject.ui.theme.ColorBlueChipInfo
import com.lucasmarciano.composeproject.ui.theme.ColorRedChipInfo

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

internal enum class ChipType(val mainColor: Color, val secondaryColor: Color) {
    ERROR(Color.Red, ColorRedChipInfo),
    INFO(ColorBlueCard, ColorBlueChipInfo)
}
