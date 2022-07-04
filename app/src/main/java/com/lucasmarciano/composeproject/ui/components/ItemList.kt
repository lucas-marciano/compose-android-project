package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasmarciano.iti_theme.ItiTheme

@Composable
fun ItemListKeyValue(
    modifier: Modifier = Modifier,
    key: String,
    value: String,
    style: TextStyle = ItiTheme.type.body2
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = key, style = style)
        Text(text = value, style = style)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ItemListKeyValuePreview() {
    Column {
        ItemListKeyValue(key = "key", value = "value")
        val modifier = Modifier
            .background(Color.White)
            .padding(20.dp)
        ItemListKeyValue(modifier = modifier, key = "key1", value = "value1")

    }
}
