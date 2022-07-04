package com.lucasmarciano.composeproject.features.sales.header

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.data.models.SalesInformationVO
import com.lucasmarciano.composeproject.features.sales.components.ShimmerSalesHeaderController
import com.lucasmarciano.composeproject.ui.components.SecondTitle
import com.lucasmarciano.composeproject.ui.components.Title
import com.lucasmarciano.composeproject.ui.mockspreview.mockSalesResult
import com.lucasmarciano.composeproject.utils.extensions.emptyString
import com.lucasmarciano.iti_module.ItiTheme
import com.lucasmarciano.iti_module.colors.ColorSalesToolbar

@Composable
fun HeaderSalesScreen() {
    val viewModel = viewModel<HeaderSalesViewModel>()
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is HeaderSalesUIState.Loading -> HeaderSalesContent()
        is HeaderSalesUIState.Success -> HeaderSalesContent(
            isLoading = false,
            item = (state as HeaderSalesUIState.Success).data,
        )
        is HeaderSalesUIState.Error -> {
            MessageError(retryClick = { viewModel.fetchData() })
        }
    }
}

@Composable
private fun HeaderSalesContent(
    isLoading: Boolean = true,
    item: SalesInformationVO = SalesInformationVO(),
) {
    val mItem by remember { mutableStateOf(item) }
    val mIsLoading by remember { mutableStateOf(isLoading) }

    ShimmerSalesHeaderController(isLoading = mIsLoading) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(ColorSalesToolbar)
                .padding(all = ItiTheme.spacing.extraMedium)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.my_business_img_coin),
                contentDescription = emptyString(),
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
            )

            SecondTitle(
                text = mItem.title,
                color = Color.White,
                modifier = Modifier.padding(
                    top = ItiTheme.spacing.medium,
                    bottom = 0.dp
                )
            )

            Title(text = mItem.value, color = Color.White)

            SecondTitle(text = mItem.subtitle, color = Color.White)
        }
    }
}

@Composable
private fun MessageError(retryClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorSalesToolbar)
            .padding(all = ItiTheme.spacing.extraMedium)
            .padding(vertical = ItiTheme.spacing.huge)
            .clickable(enabled = true, onClick = retryClick)
    ) {
        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = emptyString(),
            tint = Color.White,
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
        )
        Text(
            text = stringResource(id = R.string.my_business_error_message_header_sales),
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun HeaderSalesContentPreview() {
    ItiTheme {
        HeaderSalesContent(
            isLoading = false,
            item = mockSalesResult(),
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
        HeaderSalesContent(isLoading = true)
    }
}

@Preview
@Composable
private fun MessageErrorPreview() {
    ItiTheme {
        MessageError()
    }
}
