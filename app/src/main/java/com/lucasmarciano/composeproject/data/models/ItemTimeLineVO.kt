package com.lucasmarciano.composeproject.data.models

import androidx.compose.ui.graphics.Color
import com.lucasmarciano.iti_theme.colors.ColorBlueCard
import com.lucasmarciano.iti_theme.colors.ColorBlueChipInfo
import com.lucasmarciano.iti_theme.colors.ColorRedChipInfo

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
