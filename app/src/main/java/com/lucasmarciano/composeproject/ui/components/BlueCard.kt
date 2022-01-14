package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasmarciano.composeproject.features.models.ItemCardHome
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCard
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCardWithIcon
import com.lucasmarciano.composeproject.ui.theme.CoinIcon
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
fun BlueCard(item: ItemCardHome, onClick: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Blue)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.text,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.Start,
            )
            if (item.hasIcon()) CoinIcon(size = 40.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultBlueBoxPreview() {
    ComposeProjectTheme {
        BlueCard(mockItemCard())
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultBlueBoxWithIconPreview() {
    ComposeProjectTheme {
        BlueCard(mockItemCardWithIcon())
    }
}
