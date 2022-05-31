package com.lucasmarciano.composeproject.data.models

import androidx.annotation.DrawableRes
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.utils.extensions.emptyString

internal data class ErrorVO(
    val image: ErrorImage = ErrorImage.CONNECTION_ERROR,
    val title: String,
    val description: String,
    val closeAction: String = emptyString(),
    val callToActionVO: CallToActionVO = CallToActionVO()
)

enum class ErrorImage(@DrawableRes val imageId: Int) {
    CONNECTION_ERROR(R.drawable.img_error_cone),
    EMPTY_ERROR(R.drawable.img_error_list);
}