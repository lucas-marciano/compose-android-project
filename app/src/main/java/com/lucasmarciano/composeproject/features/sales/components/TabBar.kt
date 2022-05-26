package com.lucasmarciano.composeproject.features.sales.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.features.sales.components.TabItem.Charges.findTab
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing

@Composable
internal fun SalesTabBar(
    modifier: Modifier = Modifier,
    vararg tabs: TabItem,
    backgroundColor: Color = MaterialTheme.colors.background,
    tabSelected: TabItem = TabItem.Selling,
    onTabSelected: (TabItem) -> Unit,
) {
    TabRow(
        selectedTabIndex = tabSelected.id,
        modifier = modifier
            .height(MaterialTheme.spacing.toolbarHeight)
            .background(backgroundColor),
        contentColor = MaterialTheme.colors.onSurface,
        divider = { },
        indicator = { }
    ) {
        tabs.forEachIndexed { _, tab ->
            SalesTab(
                tab = tab,
                onTabSelected = { newTab -> onTabSelected(findTab(newTab)) },
                isSelected = tab.id == tabSelected.id
            )
        }
    }
}

@Composable
private fun SalesTab(
    tab: TabItem,
    onTabSelected: (TabItem) -> Unit,
    isSelected: Boolean = false
) {
    Tab(
        modifier = Modifier
            .padding(horizontal = MaterialTheme.spacing.extraSmall)
            .clip(RoundedCornerShape(MaterialTheme.spacing.medium)),
        selected = isSelected,
        onClick = { onTabSelected(tab) }
    ) {
        Text(
            text = stringResource(id = tab.name),
            fontWeight = FontWeight.SemiBold,
            color = if (isSelected) MaterialTheme.colors.onBackground else Color.Gray
        )
    }
}

@Preview
@Composable
private fun TabsPreview() {
    ComposeProjectTheme {
        SalesTabBar(
            tabs = arrayOf(TabItem.Selling, TabItem.Charges),
            onTabSelected = {}
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun TabsDarkPreview() {
    ComposeProjectTheme {
        SalesTabBar(
            tabs = arrayOf(TabItem.Selling, TabItem.Charges),
            onTabSelected = {}
        )
    }
}
