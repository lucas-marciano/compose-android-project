package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.data.settings.models.ItemMenuVO
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemMenu
import com.lucasmarciano.iti_module.ItiTheme
import com.lucasmarciano.iti_module.colors.ColorPinkCalifornia

@Composable
internal fun ItemMenu(item: ItemMenuVO) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = ItiTheme.spacing.medium)
            .clickable(enabled = true, onClick = { }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.WbSunny,
            contentDescription = "",
            tint = ColorPinkCalifornia
        )
        Spacer(modifier = Modifier.width(width = ItiTheme.spacing.medium))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.callToActionVO.name,
                style = ItiTheme.type.body2,
                color = ItiTheme.colors.onBg
            )
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "",
                tint = ColorPinkCalifornia
            )
        }
    }
}

@Preview(name = "Item menu", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ItemMenuPreview() {
    ItiTheme {
        ItemMenu(item = mockItemMenu())
    }
}

@Preview(name = "Item Menu Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ItemMenuDarkPreview() {
    ItiTheme {
        ItemMenu(item = mockItemMenu())
    }
}
