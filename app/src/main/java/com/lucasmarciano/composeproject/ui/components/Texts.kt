package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
fun Title(
    text: String = stringResource(id = R.string.label_empty),
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(bottom = MaterialTheme.spacing.small)
    )
}

@Composable
fun SecondTitle(
    text: String = stringResource(id = R.string.label_empty),
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.h2,
        modifier = Modifier.padding(bottom = MaterialTheme.spacing.small)
    )
}

@Composable
fun Body(
    text: String = stringResource(id = R.string.label_empty),
    color: Color = MaterialTheme.colors.primaryVariant,
) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(bottom = MaterialTheme.spacing.small)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun TextsPreviews() {
    ComposeProjectTheme {
        Column {
            Title("Hello title")
            SecondTitle("Hello second title")
            Body("Hello body")
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextsDarkPreviews() {
    ComposeProjectTheme {
        Column {
            Title("Hello title")
            SecondTitle("Hello second title")
            Body("Hello body")
        }
    }
}
