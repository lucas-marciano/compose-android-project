package com.lucasmarciano.composeproject.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
fun Title(title: String = stringResource(id = R.string.label_my_business)) {
    Text(
        text = title,
        color = Color.Black,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        softWrap = false
    )
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    ComposeProjectTheme {
        Column {
            Title("Hello")
        }
    }
}
