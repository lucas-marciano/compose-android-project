@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.lucasmarciano.composeproject.features.sales.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.utils.ComposableAliasSimple
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun CombinedTab(
    modifier: Modifier = Modifier,
    vararg tabs: TabItem,
    listContents: List<ComposableAliasSimple> = emptyList()
) {
    val pagerState = rememberPagerState(
        pageCount = TabItem.Charges.getTabs().size,
        initialOffscreenLimit = 2,
        infiniteLoop = true,
        initialPage = 0,
    )

    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ComposeProjectTheme.colors.bgVariant)
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            modifier = modifier
                .height(ComposeProjectTheme.spacing.toolbarHeight),
            contentColor = ComposeProjectTheme.colors.onBrandVariant,
            divider = {},
            indicator = {}
        ) {
            tabs.forEachIndexed { index, tab ->
                SalesTab(
                    tab = tab,
                    onTabSelected = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    isSelected = tabIndex == index
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .background(ComposeProjectTheme.colors.bg),

            ) {
            when (pagerState.currentPage) {
                TabItem.Charges.id -> {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(ComposeProjectTheme.colors.bg),
                        content = listContents[TabItem.Charges.id]
                    )
                }
                TabItem.Selling.id -> {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(ComposeProjectTheme.colors.bg),
                        content = listContents[TabItem.Selling.id]
                    )
                }
            }
        }
    }
}

@Composable
private fun SalesTab(
    tab: TabItem,
    onTabSelected: () -> Unit,
    isSelected: Boolean = false
) {
    Tab(
        modifier = Modifier
            .fillMaxHeight()
            .background(ComposeProjectTheme.colors.bg)
            .padding(horizontal = ComposeProjectTheme.spacing.extraSmall)
            .clip(RoundedCornerShape(ComposeProjectTheme.spacing.medium)),
        selected = isSelected,
        onClick = { onTabSelected() }
    ) {
        Text(
            text = stringResource(id = tab.name),
            fontWeight = FontWeight.SemiBold,
            color = if (isSelected) ComposeProjectTheme.colors.onBg else Color.Gray
        )
    }
}

@Preview
@Composable
private fun TabsPreview() {
    ComposeProjectTheme {
        CombinedTab(
            tabs = arrayOf(TabItem.Selling, TabItem.Charges),
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun TabsDarkPreview() {
    ComposeProjectTheme {
        CombinedTab(
            tabs = arrayOf(TabItem.Selling, TabItem.Charges),
            listContents = listOf({ Text(text = "aba 1") }, { Text(text = "aba 2") })
        )
    }
}
