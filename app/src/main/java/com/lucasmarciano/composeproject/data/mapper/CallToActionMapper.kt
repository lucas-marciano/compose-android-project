package com.lucasmarciano.composeproject.data.mapper

import com.lucasmarciano.composeproject.data.models.CallToActionVO
import com.lucasmarciano.composeproject.data.response.CallToActionResponse


fun CallToActionResponse.mapToVO() = CallToActionVO(
    name = this.name,
    action = this.action,
)