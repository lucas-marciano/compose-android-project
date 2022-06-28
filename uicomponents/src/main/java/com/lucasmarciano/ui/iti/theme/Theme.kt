package com.lucasmarciano.ui.iti.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lucasmarciano.ui.iti.theme.colors.IColorsStructure
import com.lucasmarciano.ui.iti.theme.colors.darkColorPalette
import com.lucasmarciano.ui.iti.theme.colors.lightColorPalette
import com.lucasmarciano.ui.iti.theme.colors.localLibColor
import com.lucasmarciano.ui.iti.theme.dimens.DimenShapes
import com.lucasmarciano.ui.iti.theme.dimens.Elevation
import com.lucasmarciano.ui.iti.theme.dimens.LocalLibElevation
import com.lucasmarciano.ui.iti.theme.dimens.LocalLibShapes
import com.lucasmarciano.ui.iti.theme.dimens.LocalLibSpacing
import com.lucasmarciano.ui.iti.theme.dimens.Spacing
import com.lucasmarciano.ui.iti.theme.typo.FontSize
import com.lucasmarciano.ui.iti.theme.typo.LocalLibFontSize
import com.lucasmarciano.ui.iti.theme.typo.LocalLibType
import com.lucasmarciano.ui.iti.theme.typo.Type

@Composable
fun ItiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: ComposableAliasSimple
) {
    val colorScheme = when {
        darkTheme -> darkColorPalette
        else -> lightColorPalette
    }

    val view = LocalView.current

    val systemUiController = rememberSystemUiController()

    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.brand.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
            systemUiController.setSystemBarsColor(
                color = colorScheme.brand, darkIcons = darkTheme.not()
            )
        }
    }

    ProvideTheme(colorScheme) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = debugType(),
            shapes = Shapes(),
            content = content
        )
    }
}

object ItiTheme {
    val colors: IColorsStructure
        @Composable get() = localLibColor().current

    val spacing: Spacing
        @Composable get() = LocalLibSpacing.current

    val elevation: Elevation
        @Composable get() = LocalLibElevation.current

    val fontSize: FontSize
        @Composable get() = LocalLibFontSize.current

    val type: Type
        @Composable get() = LocalLibType.current

    val shapes: DimenShapes
        @Composable get() = LocalLibShapes.current
}

@Composable
private fun ProvideTheme(
    colors: IColorsStructure, content: ComposableAliasSimple
) {
    val colorPalette = remember { colors }
    CompositionLocalProvider(
        localLibColor() provides colorPalette,
        LocalLibType provides Type(),
        LocalLibSpacing provides Spacing(),
        LocalLibElevation provides Elevation(),
        LocalLibShapes provides DimenShapes(),
        LocalLibFontSize provides FontSize(),
        content = content
    )
}

internal fun debugColors(darkTheme: Boolean, debugColor: Color = Color.Magenta) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)

internal fun debugType() = Typography()
