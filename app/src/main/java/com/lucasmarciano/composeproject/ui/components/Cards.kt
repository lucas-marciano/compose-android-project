package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.features.models.ItemCardHome
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCard
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCardWithIcon
import com.lucasmarciano.composeproject.ui.mockspreview.mockSimpleItemCardWithIcon
import com.lucasmarciano.composeproject.ui.theme.CoinIcon
import com.lucasmarciano.composeproject.ui.theme.ColorBlueCard
import com.lucasmarciano.composeproject.ui.theme.ColorPinkCalifornia
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
fun BlueCard(item: ItemCardHome, onClick: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(ColorBlueCard)
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
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
            )
            if (item.hasIcon()) CoinIcon(size = 40.dp)
        }
    }
}


@Composable
fun CardWithIcon(item: ItemCardHome, onClick: () -> Unit = { }) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .width(80.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                painter = painterResource(id = R.drawable.ic_money_info),
                contentDescription = "",
                tint = ColorPinkCalifornia
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.text,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
            )

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


@Preview(showBackground = true)
@Composable
fun DefaultCardPreview() {
    ComposeProjectTheme {
        CardWithIcon(mockSimpleItemCardWithIcon())
    }
}
