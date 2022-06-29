package com.lucasmarciano.iti_module.dimens

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp
import com.lucasmarciano.core.theme.IShape

data class DimenShapes(
    override val noShape: CornerBasedShape = RoundedCornerShape(0.dp),
    override val small: CornerBasedShape = RoundedCornerShape(4.dp),
    override val medium: CornerBasedShape = RoundedCornerShape(8.dp),
    override val large: CornerBasedShape = RoundedCornerShape(16.dp)
) : IShape

val LocalLibShapes = compositionLocalOf { DimenShapes() }