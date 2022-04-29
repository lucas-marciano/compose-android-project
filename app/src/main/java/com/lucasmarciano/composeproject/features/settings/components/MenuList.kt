package com.lucasmarciano.composeproject.features.settings.components

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.data.settings.models.ItemMenuVO
import com.lucasmarciano.composeproject.ui.components.ItemMenu
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemMenuList

@Composable
internal fun MenuList(list: List<ItemMenuVO>) {
    LazyColumn {
        items(list) { menu ->
            ItemMenu(item = menu)
            if (list.last() != menu) Divider(color = Color.LightGray)
        }
    }
}


@Preview(name = "Menu List", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun MenuListPreview() {
    MenuList(list = mockItemMenuList())
}

@Preview(name = "Menu List Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MenuListDarkPreview() {
    MenuList(list = mockItemMenuList())
}
