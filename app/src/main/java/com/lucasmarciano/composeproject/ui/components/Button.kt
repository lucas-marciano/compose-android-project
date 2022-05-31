package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.ui.theme.ColorPinkCalifornia
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@Composable
fun ButtonBordLess(callToAction: CallToActionVO?) {
    callToAction?.let {
        Text(
            modifier = Modifier
                .padding(all = ComposeProjectTheme.spacing.extraSmall)
                .clickable(enabled = true, onClickLabel = it.name, onClick = { }),
            text = it.name,
            color = ColorPinkCalifornia,
            style = ComposeProjectTheme.type.button
        )
    }
}


@Preview(name = "ButtonBordLess", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ButtonBordLessPreview() {
    ButtonBordLess(
        CallToActionVO(
            name = "click",
            action = "action"
        )
    )
}

@Preview(
    name = "ButtonBordLess Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun ButtonBordLessDarkPreview() {
    ButtonBordLess(
        CallToActionVO(
            name = "click",
            action = "action"
        )
    )
}
