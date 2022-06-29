package com.lucasmarciano.composeproject.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.data.home.models.ItemCardHomeVO
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCard
import com.lucasmarciano.composeproject.ui.mockspreview.mockItemCardWithIcon
import com.lucasmarciano.composeproject.ui.mockspreview.mockSimpleItemCardWithIcon
import com.lucasmarciano.composeproject.ui.theme.CoinIcon
import com.lucasmarciano.composeproject.ui.values.CardComponent
import com.lucasmarciano.composeproject.ui.values.InfoKeyValue
import com.lucasmarciano.composeproject.ui.values.PaymentInfo
import com.lucasmarciano.composeproject.ui.values.TypeCard
import com.lucasmarciano.composeproject.utils.extensions.emptyString
import com.lucasmarciano.ui.iti.theme.ComposableAliasSimple
import com.lucasmarciano.ui.iti.theme.ItiTheme
import com.lucasmarciano.ui.iti.theme.colors.ColorBlueCard
import com.lucasmarciano.ui.iti.theme.colors.ColorBlueFooter
import com.lucasmarciano.ui.iti.theme.colors.ColorPinkCalifornia

@Composable
internal fun BuildCard(cardComponent: CardComponent) {
    val (isExpandable, icon, title, details, information, paymentInfo, footer, typeCard, _) = cardComponent
    when (typeCard) {
        TypeCard.NORMAL -> NormalCard(isExpandable, icon, title, details, footer)
        TypeCard.INFO -> InfoCard(isExpandable, icon, title, information)
        TypeCard.PAYMENT -> PaymentCard(details, paymentInfo)
    }
}

@Composable
internal fun CardMainStructure(
    isExpandable: Boolean = false,
    icon: String? = null,
    title: String = emptyString(),
    component: ComposableAliasSimple = {}
) {
    var isVisible by remember { mutableStateOf(isExpandable.not()) }

    val arrowIcon = produceState(initialValue = Icons.Outlined.ExpandMore, isVisible) {
        value = if (isVisible) Icons.Outlined.ExpandLess else Icons.Outlined.ExpandMore
    }

    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(ItiTheme.colors.bg)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(if (title.isNotEmpty()) ItiTheme.spacing.medium else 0.dp)
                    .clickable(onClick = { if (isExpandable) isVisible = !isVisible }),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(verticalAlignment = Alignment.Top) {
                    icon?.let {
                        Icon(
                            modifier = Modifier.size(ItiTheme.spacing.large),
                            imageVector = Icons.Filled.CreditCard,
                            contentDescription = emptyString(),
                            tint = ColorPinkCalifornia
                        )
                        Spacer(modifier = Modifier.width(ItiTheme.spacing.small))
                    }
                    Title(text = title)
                }
                if (isExpandable) {
                    Icon(
                        modifier = Modifier.size(ItiTheme.spacing.large),
                        imageVector = arrowIcon.value,
                        contentDescription = emptyString(),
                        tint = ItiTheme.colors.onBg
                    )
                }
            }

            AnimatedVisibility(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ItiTheme.colors.bg),
                visible = isVisible
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(ItiTheme.colors.bg),
                    content = component
                )
            }
        }
    }
}

@Composable
internal fun NormalCard(
    isExpandable: Boolean, icon: String, title: String, details: String, footer: InfoKeyValue?
) {
    CardMainStructure(
        isExpandable, icon, title
    ) {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween) {

            Text(
                modifier = Modifier
                    .padding(horizontal = ItiTheme.spacing.medium)
                    .padding(bottom = ItiTheme.spacing.medium),
                text = details,
                style = ItiTheme.type.body2,
                lineHeight = 20.sp,
                color = ItiTheme.colors.onBrand
            )

            footer?.let {
                ItemListKeyValue(
                    modifier = Modifier
                        .background(ColorBlueFooter)
                        .fillMaxWidth()
                        .padding(ItiTheme.spacing.extraMedium),
                    key = footer.key,
                    value = footer.value,
                    style = ItiTheme.type.body1
                )
            }
        }
    }
}

@Composable
internal fun InfoCard(
    isExpandable: Boolean = false, icon: String? = null, title: String, listInfo: List<InfoKeyValue>
) {
    CardMainStructure(isExpandable, icon, title) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = ItiTheme.spacing.extraMedium)
        ) {
            items(listInfo) { item ->
                ItemListKeyValue(
                    modifier = Modifier.padding(horizontal = ItiTheme.spacing.extraMedium),
                    key = item.key,
                    value = item.value,
                )
            }
        }
    }
}

@Composable
internal fun PaymentCard(details: String = emptyString(), paymentInfo: PaymentInfo?) {
    CardMainStructure {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween) {
            paymentInfo?.apply {
                Text(
                    modifier = Modifier
                        .padding(horizontal = ItiTheme.spacing.extraMedium)
                        .padding(bottom = ItiTheme.spacing.medium),
                    text = details,
                    style = ItiTheme.type.body2,
                    lineHeight = 20.sp,
                    color = ItiTheme.colors.onBrand
                )

                paymentDetails.let {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = ItiTheme.spacing.extraMedium)
                    ) {
                        items(it) { item ->
                            ItemListKeyValue(
                                modifier = Modifier.padding(horizontal = ItiTheme.spacing.extraMedium),
                                key = item.key,
                                value = item.value,
                            )
                        }
                    }
                }

                footerInfo?.let {
                    ItemListKeyValue(
                        modifier = Modifier
                            .background(ColorBlueFooter)
                            .fillMaxWidth()
                            .padding(ItiTheme.spacing.extraMedium),
                        key = it.key,
                        value = it.value,
                        style = ItiTheme.type.body1
                    )
                }
            }
        }
    }
}

@Composable
fun BlueCard(item: ItemCardHomeVO, onClick: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .height(ItiTheme.spacing.cardHeight)
            .width(ItiTheme.spacing.cardWidth)
            .clip(RoundedCornerShape(ItiTheme.spacing.small))
            .background(ColorBlueCard)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(ItiTheme.spacing.defaultPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.text,
                color = Color.White,
                style = ItiTheme.type.body1,
            )
            if (item.hasIcon()) {
                CoinIcon(
                    size = ItiTheme.spacing.largeIcon, color = Color.White
                )
            }
        }
    }
}

@Composable
fun CardWithIcon(item: ItemCardHomeVO, onClick: () -> Unit = { }) {
    Card(
        modifier = Modifier
            .height(ItiTheme.spacing.extraHuge)
            .width(ItiTheme.spacing.extraHuge)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(ItiTheme.spacing.small),
        elevation = ItiTheme.elevation.extraSmall,
        backgroundColor = ItiTheme.colors.bg
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(ItiTheme.spacing.defaultPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                modifier = Modifier.size(ItiTheme.spacing.smallIcon),
                painter = painterResource(id = R.drawable.ic_money_info),
                contentDescription = "",
                tint = ColorPinkCalifornia
            )
            Text(
                text = item.text,
                color = ItiTheme.colors.onBg,
                style = ItiTheme.type.subtitle2,
            )

        }
    }
}

// region: PREVIEWS

@Preview(showBackground = true)
@Composable
fun CardsPreview() {
    ItiTheme {
        Column {
            BlueCard(mockItemCard())
            Spacer(modifier = Modifier.height(20.dp))
            BlueCard(mockItemCardWithIcon())
            Spacer(modifier = Modifier.height(20.dp))
            CardWithIcon(mockSimpleItemCardWithIcon())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NormalCardPreview() {
    NormalCard(
        isExpandable = true,
        icon = "card",
        title = "detalhe de pagamento",
        details = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
        footer = InfoKeyValue(
            "valor", "R$ 20,00"
        )
    )
}

@Preview(showBackground = true)
@Composable
fun InfoCardPreview() {
    InfoCard(
        isExpandable = true, icon = "card", title = "informações", listInfo = listOf(
            InfoKeyValue("venda", "R$ 20,00"),
            InfoKeyValue("imposto", "R$ 22,00"),
            InfoKeyValue("desconto", "R$ 24,00"),
            InfoKeyValue("valor final", "R$ 25,00"),
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PaymentCardPreview() {
    PaymentCard(
        details = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
        PaymentInfo(
            creditCard = "master",
            paymentDetails = listOf(
                InfoKeyValue("venda", "R$ 20,00"),
                InfoKeyValue("imposto", "R$ 22,00"),
                InfoKeyValue("desconto", "R$ 24,00"),
                InfoKeyValue("valor final", "R$ 25,00"),
            ),
            footerInfo = InfoKeyValue("venda", "R$ 20,00"),
        )
    )
}

// end region: PREVIEWS
