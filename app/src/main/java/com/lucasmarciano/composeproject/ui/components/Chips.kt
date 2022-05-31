package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasmarciano.composeproject.data.models.ChipType
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
internal fun Chip(text: String, chipType: ChipType = ChipType.INFO, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .border(BorderStroke(0.3.dp, chipType.mainColor), CircleShape)
            .background(chipType.secondaryColor)
            .padding(start = 6.dp, end = 6.dp, top = 2.dp, bottom = 2.dp)
            .clickable(onClickLabel = text, enabled = true, onClick = onClick)
    ) {
        Text(
            text = text.lowercase(),
            style = ComposeProjectTheme.type.body2,
            fontSize = ComposeProjectTheme.fontSize.minimum,
            color = chipType.mainColor
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun ChipsPreview() {
    ComposeProjectTheme {
        Column {
            Chip("informações")
            Chip("erro", ChipType.ERROR)
        }
    }
}
