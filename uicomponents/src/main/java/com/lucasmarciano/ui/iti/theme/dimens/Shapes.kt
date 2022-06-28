package com.lucasmarciano.ui.iti.theme.dimens

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

data class DimenShapes(
    val noShape: CornerBasedShape = RoundedCornerShape(0.dp),
    val small: CornerBasedShape = RoundedCornerShape(4.dp),
    val medium: CornerBasedShape = RoundedCornerShape(8.dp),
    val large: CornerBasedShape = RoundedCornerShape(16.dp)
)

val LocalLibShapes = compositionLocalOf { DimenShapes() }