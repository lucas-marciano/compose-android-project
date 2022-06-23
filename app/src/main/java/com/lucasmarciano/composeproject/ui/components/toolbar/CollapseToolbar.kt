@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.lucasmarciano.composeproject.ui.components.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import com.lucasmarciano.ui.iti.theme.colors.ColorSalesToolbar
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.Const.BottomSheetShape
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent
import com.lucasmarciano.composeproject.ui.values.TypeToolbar
import com.lucasmarciano.composeproject.utils.ComposableAliasSimple

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CollapseToolbar(
    toolbar: ToolbarComponent,
    onClickBack: (String) -> Unit = { },
    onClick: () -> Unit = { },
    header: ComposableAliasSimple,
    content: ComposableAliasSimple,
) {
    val backDropState = rememberBackdropScaffoldState(BackdropValue.Revealed)

    BackdropScaffold(
        modifier = Modifier.background(ColorSalesToolbar),
        frontLayerShape = BottomSheetShape,
        frontLayerScrimColor = Color.Unspecified,
        scaffoldState = backDropState,
        appBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ColorSalesToolbar)
                    .statusBarsPadding()
                    .height(ComposeProjectTheme.spacing.toolbarHeight)
                    .padding(horizontal = 8.dp)
            ) {
                BuildBackAction(toolbar, onClickBack)
                Text(
                    text = toolbar.title,
                    textAlign = TextAlign.Center,
                    style = ComposeProjectTheme.type.subtitle1,
                    color = Color.White
                )
                BuildAction(toolbar, onClick)
            }
        },
        backLayerContent = header,
        frontLayerContent = content
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, showSystemUi = true)
@Composable
private fun CollapseToolBarPreview() {
    ComposeProjectTheme {
        CollapseToolbar(
            toolbar = ToolbarComponent("toolbar", type = TypeToolbar.BLUE),
            header = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "header",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "content")
            }
        }
    }
}
