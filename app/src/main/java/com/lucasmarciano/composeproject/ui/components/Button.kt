package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.ui.values.ButtonComponent
import com.lucasmarciano.composeproject.ui.values.TypeButton
import com.lucasmarciano.iti_module.ItiTheme
import com.lucasmarciano.iti_module.colors.ColorPinkCalifornia

@Composable
internal fun BuildButton(buttonComponent: ButtonComponent) {
    val (action, type, icon) = buttonComponent
    when (type) {
        TypeButton.NORMAL -> ButtonDefault(action, icon)
        TypeButton.BORDERLESS -> ButtonBordLess(action)
        TypeButton.OUTLINED -> ButtonOutlined(action, icon)
    }
}

@Composable
fun ButtonDefault(callToAction: CallToActionVO, icon: String? = null) {
    Button(
        onClick = callToAction.onClick,
        shape = ItiTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ColorPinkCalifornia,
            contentColor = ItiTheme.colors.onBg
        ),
        contentPadding = PaddingValues(
            start = ItiTheme.spacing.medium,
            top = ItiTheme.spacing.small,
            end = ItiTheme.spacing.medium,
            bottom = ItiTheme.spacing.small
        )
    ) {
        icon?.let {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = callToAction.name,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }

        Text(callToAction.name, style = ItiTheme.type.button)
    }
}

@Composable
fun ButtonOutlined(callToAction: CallToActionVO, icon: String? = null) {
    OutlinedButton(
        onClick = callToAction.onClick,
        shape = ItiTheme.shapes.small,
        border = BorderStroke(ItiTheme.spacing.border, ColorPinkCalifornia),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = ColorPinkCalifornia
        ),
        contentPadding = PaddingValues(
            start = ItiTheme.spacing.medium,
            top = ItiTheme.spacing.small,
            end = ItiTheme.spacing.medium,
            bottom = ItiTheme.spacing.small
        )
    ) {
        icon?.let {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = callToAction.name,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
        Text(callToAction.name, style = ItiTheme.type.button)
    }
}

@Composable
fun ButtonBordLess(callToAction: CallToActionVO?) {
    callToAction?.let {
        Text(
            modifier = Modifier
                .padding(all = ItiTheme.spacing.extraSmall)
                .clickable(enabled = true, onClickLabel = it.name, onClick = it.onClick),
            text = it.name,
            color = ColorPinkCalifornia,
            style = ItiTheme.type.button
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun BuildButtonPreview() {
    Column {
        BuildButton(
            ButtonComponent(
                CallToActionVO(
                    name = "click",
                    action = "action"
                ),
                TypeButton.NORMAL
            )
        )
        BuildButton(
            ButtonComponent(
                CallToActionVO(
                    name = "click",
                    action = "action"
                ),
                TypeButton.BORDERLESS,
            )
        )
        BuildButton(
            ButtonComponent(
                CallToActionVO(
                    name = "click",
                    action = "action"
                ),
                TypeButton.OUTLINED,
            )
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BuildButtonDarkPreview() {
    Column {
        BuildButton(
            ButtonComponent(
                CallToActionVO(
                    name = "click",
                    action = "action"
                ),
                TypeButton.NORMAL
            )
        )
        BuildButton(
            ButtonComponent(
                CallToActionVO(
                    name = "click",
                    action = "action"
                ),
                TypeButton.BORDERLESS,
            )
        )
        BuildButton(
            ButtonComponent(
                CallToActionVO(
                    name = "click",
                    action = "action"
                ),
                TypeButton.OUTLINED,
            )
        )
    }
}
