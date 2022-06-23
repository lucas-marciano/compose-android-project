@file:Suppress("OPT_IN_IS_NOT_ENABLED")
@file:OptIn(ExperimentalFoundationApi::class)

package com.lucasmarciano.composeproject.features.sales.timeline

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
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
import com.lucasmarciano.composeproject.data.models.TimeLineVO
import com.lucasmarciano.composeproject.features.sales.components.CombinedTab
import com.lucasmarciano.composeproject.features.sales.components.HeaderItem
import com.lucasmarciano.composeproject.features.sales.components.ShimmerSalesTimeListController
import com.lucasmarciano.composeproject.features.sales.components.TabItem.Charges.getTabs
import com.lucasmarciano.composeproject.ui.components.Body
import com.lucasmarciano.composeproject.ui.components.ItemTimeLineContainer
import com.lucasmarciano.composeproject.ui.components.Title
import com.lucasmarciano.composeproject.ui.mockspreview.mockListTimeLine
import com.lucasmarciano.composeproject.utils.extensions.emptyString
import com.lucasmarciano.ui.iti.theme.ItiTheme

@Composable
fun TimeLineScreen(
    onClick: (String) -> Unit = {},
) {
    val viewModel = viewModel<TimeLineViewModel>()
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is TimeLineUIState.Loading -> TimeLineContent()
        is TimeLineUIState.Success -> TimeLineContent(
            isLoading = false,
            listSells = (state as TimeLineUIState.Success).data,
            listCharges = (state as TimeLineUIState.Success).data,
            onClick = onClick,
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
    listSells: List<TimeLineVO> = emptyList(),
    listCharges: List<TimeLineVO> = emptyList(),
    onClick: (String) -> Unit = {},
) {
    ShimmerSalesTimeListController(isLoading = isLoading) {
        CombinedTab(
            tabs = getTabs(),
            listContents = listOf(
                { ListCompose(listSells, onClick) },
                { ListCompose(listCharges, onClick) },
            )
        )
    }
}

@Composable
internal fun ListCompose(
    list: List<TimeLineVO> = emptyList(),
    onClick: (String) -> Unit = {},
) {
    LazyColumn {
        list.forEach { timeline ->
            stickyHeader {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(ItiTheme.colors.bgVariant)
                ) {
                    HeaderItem(
                        title = timeline.headerTimeLineVO.title,
                        info = timeline.headerTimeLineVO.info
                    )
                }
            }

            items(timeline.list, key = { it.id }) { item ->
                ItemTimeLineContainer(item = item) { onClick(item.id) }
            }
        }
    }
}

@Composable
private fun MessageError(error: ErrorVO, retryAction: () -> Unit = { }) {
    Column(
        modifier = Modifier
            .clickable(onClick = retryAction)
            .background(ItiTheme.colors.bg)
            .padding(ItiTheme.spacing.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.padding(bottom = ItiTheme.spacing.small),
            painter = painterResource(id = error.image.imageId),
            contentDescription = emptyString()
        )
        Title(text = error.title, color = ItiTheme.colors.onBg)
        Body(text = error.description, color = ItiTheme.colors.onBgVariant)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun TimeLineContentPreview() {
    ItiTheme {
        TimeLineContent(
            isLoading = false,
            listCharges = mockListTimeLine(),
            listSells = mockListTimeLine(),
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun HeaderSalesContentLoadingPreview() {
    ItiTheme {
        TimeLineContent(isLoading = true)
    }
}

@Preview
@Composable
private fun MessageErrorEmptyPreview() {
    ItiTheme {
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
    ItiTheme {
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