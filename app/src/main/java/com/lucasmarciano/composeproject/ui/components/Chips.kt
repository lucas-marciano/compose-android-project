package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasmarciano.composeproject.ui.theme.ColorBlueCard
import com.lucasmarciano.composeproject.ui.theme.ColorBlueChipInfo
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
fun ChipInfo(text: String, onClick: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .padding(MaterialTheme.spacing.extraSmall)
            .clip(CircleShape)
            .border(BorderStroke(0.3.dp, SolidColor(ColorBlueCard)), CircleShape)
            .background(ColorBlueChipInfo)
            .padding(start = 6.dp, end = 6.dp, top = 2.dp, bottom = 2.dp)
            .clickable(onClickLabel = text, enabled = true, onClick = onClick)
    ) {
        Text(
            text = text.lowercase(),
            style = MaterialTheme.typography.body2,
            fontSize = 10.sp,
            color = ColorBlueCard
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun ChipsPreview() {
    ComposeProjectTheme {
        Column {
            ChipInfo("informações")
        }
    }
}
