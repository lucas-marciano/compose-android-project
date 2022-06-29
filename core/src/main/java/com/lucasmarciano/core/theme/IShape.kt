package com.lucasmarciano.core.theme

import androidx.compose.foundation.shape.CornerBasedShape

interface IShape {
    val noShape: CornerBasedShape
    val small: CornerBasedShape
    val medium: CornerBasedShape
    val large: CornerBasedShape
}
