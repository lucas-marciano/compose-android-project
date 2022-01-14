package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
fun Title(text: String = stringResource(id = R.string.label_empty)) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        softWrap = false
    )
}

@Composable
fun SecondTitle(text: String = stringResource(id = R.string.label_empty)) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        softWrap = false,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    ComposeProjectTheme {
        Column {
            Title("Hello")
            SecondTitle("Hello Second")
        }
    }
}
