package com.lucasmarciano.composeproject.ui.values

import com.lucasmarciano.composeproject.ui.Components
import com.lucasmarciano.composeproject.utils.extensions.emptyString

internal data class CardComponent(
    val isExpandable: Boolean = false,
    val icon: String = emptyString(),
    val title: String = emptyString(),
    val details: String = emptyString(),
    val information: Info? = null,
    val paymentInfo: PaymentInfo? = null,
) : InterfaceItemComponent(Components.CARD)

internal data class InfoKeyValue(
    val key: String,
    val value: String
)

internal data class Info(
    val listInfo: List<String> = emptyList(),
    val listPairInfo: List<InfoKeyValue> = emptyList(),
)

internal data class PaymentInfo(
    val creditCard: String,
    val paymentDetails: List<InfoKeyValue> = emptyList(),
    val footerInfo: InfoKeyValue? = null,
)
