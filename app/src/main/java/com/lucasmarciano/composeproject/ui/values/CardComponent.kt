package com.lucasmarciano.composeproject.ui.values

import com.lucasmarciano.composeproject.ui.Components
import com.lucasmarciano.composeproject.utils.extensions.emptyString

internal data class CardComponent(
    val isExpandable: Boolean = false,
    val icon: String = emptyString(),
    val title: String = emptyString(),
    val details: String = emptyString(),
    val information: List<InfoKeyValue> = emptyList(),
    val paymentInfo: PaymentInfo? = null,
    val footer: InfoKeyValue? = null,
    val typeCard: TypeCard = TypeCard.NORMAL,
    val segueAction: String = emptyString()
) : InterfaceItemComponent(Components.CARD)

enum class TypeCard {
    NORMAL,
    INFO,
    PAYMENT,
}

internal data class InfoKeyValue(
    val key: String,
    val value: String
)

internal data class PaymentInfo(
    val creditCard: String,
    val paymentDetails: List<InfoKeyValue> = emptyList(),
    val footerInfo: InfoKeyValue? = null,
)
