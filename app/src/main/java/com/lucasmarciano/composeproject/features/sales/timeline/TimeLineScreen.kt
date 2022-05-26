package com.lucasmarciano.composeproject.features.sales.timeline

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.data.models.ErrorImage
import com.lucasmarciano.composeproject.data.models.ErrorVO
import com.lucasmarciano.composeproject.data.models.ItemTimeLineVO
import com.lucasmarciano.composeproject.features.sales.components.SalesTabBar
import com.lucasmarciano.composeproject.features.sales.components.ShimmerSalesTimeListController
import com.lucasmarciano.composeproject.features.sales.components.TabItem
import com.lucasmarciano.composeproject.features.sales.components.TabItem.Charges.getTabs
import com.lucasmarciano.composeproject.ui.components.Body
import com.lucasmarciano.composeproject.ui.components.ItemTimeLineContainer
import com.lucasmarciano.composeproject.ui.components.Title
import com.lucasmarciano.composeproject.ui.mockspreview.mockListItemTimeLine
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.spacing
import com.lucasmarciano.composeproject.utils.extensions.emptyString

@Composable
fun TimeLineScreen(
    tabSelected: TabItem = TabItem.Selling,
    onClick: (String) -> Unit = {},
    onTabSelected: (TabItem) -> Unit = {},
) {
    val viewModel = viewModel<TimeLineViewModel>()
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is TimeLineUIState.Loading -> TimeLineContent()
        is TimeLineUIState.Success -> TimeLineContent(
            isLoading = false,
            listSells = (state as TimeLineUIState.Success).data,
            listCharges = (state as TimeLineUIState.Success).data,
            tabSelected = tabSelected,
            onClick = onClick,
            onTabSelected = onTabSelected,
        )
        is TimeLineUIState.ErrorEmpty -> {
            MessageError(
                error = ErrorVO(
                    ErrorImage.EMPTY_ERROR,
                    stringResource(id = R.string.my_business_title_no_sales),
                    stringResource(id = R.string.my_business_describe_no_sales),
                ),
                retryAction = { viewModel.fetchData() }
            )
        }
        is TimeLineUIState.Error -> {
            MessageError(
                error = ErrorVO(
                    ErrorImage.CONNECTION_ERROR,
                    stringResource(id = R.string.my_business_title_connection_error),
                    stringResource(id = R.string.my_business_describe_connection_error),
                ),
                retryAction = { viewModel.fetchData() }
            )
        }
    }
}

@Composable
private fun TimeLineContent(
    isLoading: Boolean = true,
    listSells: List<ItemTimeLineVO> = emptyList(),
    listCharges: List<ItemTimeLineVO> = emptyList(),
    onClick: (String) -> Unit = {},
    tabSelected: TabItem = TabItem.Selling,
    onTabSelected: (TabItem) -> Unit = {},
) {
    ShimmerSalesTimeListController(isLoading = isLoading) {
        Column(modifier = Modifier.fillMaxWidth()) {
            SalesTabBar(
                tabs = getTabs(),
                tabSelected = tabSelected,
                onTabSelected = onTabSelected
            )
            when (tabSelected) {
                TabItem.Charges -> {
                    ListCompose(listCharges, onClick)
                }
                TabItem.Selling -> {
                    ListCompose(listSells, onClick)
                }
            }
        }
    }
}

@Composable
private fun ListCompose(
    list: List<ItemTimeLineVO> = emptyList(),
    onClick: (String) -> Unit = {},
) {
    LazyColumn {
        items(list, key = { it.id }) { item ->
            ItemTimeLineContainer(item = item) { onClick(item.id) }
        }
    }
}

@Composable
private fun MessageError(error: ErrorVO, retryAction: () -> Unit = { }) {
    Column(
        modifier = Modifier
            .clickable(onClick = retryAction)
            .background(MaterialTheme.colors.background)
            .padding(MaterialTheme.spacing.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.padding(bottom = MaterialTheme.spacing.small),
            painter = painterResource(id = error.image.imageId),
            contentDescription = emptyString()
        )
        Title(text = error.title, color = MaterialTheme.colors.onBackground)
        Body(text = error.description, color = MaterialTheme.colors.onSurface)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun TimeLineContentPreview() {
    ComposeProjectTheme {
        TimeLineContent(
            isLoading = false,
            listCharges = mockListItemTimeLine(),
            listSells = mockListItemTimeLine(),
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun HeaderSalesContentLoadingPreview() {
    ComposeProjectTheme {
        TimeLineContent(isLoading = true)
    }
}

@Preview
@Composable
private fun MessageErrorEmptyPreview() {
    ComposeProjectTheme {
        MessageError(
            ErrorVO(
                ErrorImage.EMPTY_ERROR,
                "não existem vendas",
                "começe a vendar para poder listar novas vendas",
            )
        )
    }
}

@Preview
@Composable
private fun MessageErrorConnectionPreview() {
    ComposeProjectTheme {
        MessageError(
            ErrorVO(
                ErrorImage.CONNECTION_ERROR,
                "ocorreu um erro",
                "não conseguimos conectar, tente novamente",
                closeAction = "",
            )
        )
    }
}