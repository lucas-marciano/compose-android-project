package com.lucasmarciano.composeproject.ui.components.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.statusBarsPadding
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.ui.theme.ColorBlueCard
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.utils.Const.APP_BAR_COLLAPSED_HEIGHT
import com.lucasmarciano.composeproject.ui.utils.Const.BottomSheetShape
import com.lucasmarciano.composeproject.ui.values.ToolbarComponent
import com.lucasmarciano.composeproject.ui.values.TypeToolbar

@Composable
internal fun CollapseToolBar(
    toolbar: ToolbarComponent,
    onClickBack: (String) -> Unit = { },
    onClick: () -> Unit = { },
) {
    val scrollState = rememberLazyListState()
    Box {
        MainContent(scrollState)
        HeaderToolbar(toolbar)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CollapseToolbar(
    toolbar: ToolbarComponent,
    onClickBack: (String) -> Unit = { },
    onClick: () -> Unit = { },
) {
    val scrollState = rememberLazyListState()
    val backDropState = rememberBackdropScaffoldState(BackdropValue.Revealed)

    BackdropScaffold(
        modifier = Modifier.background(getBgColor(typeToolbar = toolbar.type)),
        frontLayerShape = BottomSheetShape,
        frontLayerScrimColor = Color.Unspecified,
        scaffoldState = backDropState,
        appBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(getBgColor(typeToolbar = toolbar.type))
                    .statusBarsPadding()
                    .height(APP_BAR_COLLAPSED_HEIGHT)
                    .padding(horizontal = 8.dp)
            ) {
                BuildBackAction(toolbar, onClickBack)
                Text(
                    text = toolbar.title,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )
                BuildAction(toolbar, onClick)
            }
        },
        backLayerContent = {
            HeaderToolbar(toolbar)
        },
        frontLayerContent = {
            MainContent(scrollState)
        }
    )
}

@Composable
internal fun HeaderToolbar(
    toolbar: ToolbarComponent,
) {

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(getBgColor(toolbar.type))
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_money_info),
                        contentDescription = "Profile",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(100.dp)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "@Make it Easy",
                        fontSize = 25.sp,
                        color = Color.White,
                        maxLines = 1,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "makeiteasy@abc.com",
                        fontSize = 15.sp,
                        color = Color.White,
                        maxLines = 1,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(2.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun getBgColor(typeToolbar: TypeToolbar): Color {
    return when (typeToolbar) {
        TypeToolbar.NORMAL -> MaterialTheme.colors.primary
        TypeToolbar.BLUE -> ColorBlueCard
    }
}

@Composable
fun MainContent(scrollState: LazyListState) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        LazyColumn(state = scrollState) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    for (i in 0..24) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(75.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_money_info),
                                    contentDescription = "Profile Image",
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Column {
                                    Text(
                                        text = "Developer",
                                        color = Color.Black,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "+91-1234567890",
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, showSystemUi = true)
@Composable
fun CollapseToolBarPreview() {
    ComposeProjectTheme {
//        CollapseToolBar(ToolbarComponent("seu négocio", type = TypeToolbar.BLUE))
        CollapseToolbar(ToolbarComponent("seu négocio", type = TypeToolbar.BLUE))
    }
}
