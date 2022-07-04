package com.lucasmarciano.iti_theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.lucasmarciano.core.theme.IColor
import com.lucasmarciano.core.theme.IElevation
import com.lucasmarciano.core.theme.IFontSize
import com.lucasmarciano.core.theme.IShape
import com.lucasmarciano.core.theme.ISpacing
import com.lucasmarciano.core.theme.ITheme
import com.lucasmarciano.core.theme.IType
import com.lucasmarciano.iti_theme.colors.localLibColor
import com.lucasmarciano.iti_theme.dimens.LocalLibElevation
import com.lucasmarciano.iti_theme.dimens.LocalLibShapes
import com.lucasmarciano.iti_theme.dimens.LocalLibSpacing
import com.lucasmarciano.iti_theme.typo.LocalLibFontSize
import com.lucasmarciano.iti_theme.typo.LocalLibType

object ItiTheme : ITheme {
    override val colors: IColor
        @Composable get() = localLibColor(isSystemInDarkTheme()).current
    override val spacing: ISpacing
        @Composable get() = LocalLibSpacing.current
    override val elevation: IElevation
        @Composable get() = LocalLibElevation.current
    override val fontSize: IFontSize
        @Composable get() = LocalLibFontSize.current
    override val type: IType
        @Composable get() = LocalLibType.current
    override val shapes: IShape
        @Composable get() = LocalLibShapes.current
}