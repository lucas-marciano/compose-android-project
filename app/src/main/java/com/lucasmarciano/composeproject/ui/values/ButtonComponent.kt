package com.lucasmarciano.composeproject.ui.values

import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.ui.Components
import com.lucasmarciano.core.utils.emptyString

internal data class ButtonComponent(
    val callToActionVO: CallToActionVO,
    val type: TypeButton = TypeButton.NORMAL,
    val icon: String = emptyString()
) : InterfaceItemComponent(Components.BUTTON)

enum class TypeButton {
    NORMAL,
    BORDERLESS,
    OUTLINED,
}
