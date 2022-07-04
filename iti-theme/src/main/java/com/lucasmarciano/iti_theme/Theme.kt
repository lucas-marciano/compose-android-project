package com.lucasmarciano.iti_theme

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
import com.lucasmarciano.core.utils.ComposableAliasSimple
import com.lucasmarciano.iti_theme.colors.IColorsStructure
import com.lucasmarciano.iti_theme.colors.darkColorPalette
import com.lucasmarciano.iti_theme.colors.lightColorPalette
import com.lucasmarciano.iti_theme.colors.localLibColor
import com.lucasmarciano.iti_theme.dimens.DimenShapes
import com.lucasmarciano.iti_theme.dimens.Elevation
import com.lucasmarciano.iti_theme.dimens.LocalLibElevation
import com.lucasmarciano.iti_theme.dimens.LocalLibShapes
import com.lucasmarciano.iti_theme.dimens.LocalLibSpacing
import com.lucasmarciano.iti_theme.dimens.Spacing
import com.lucasmarciano.iti_theme.typo.FontSize
import com.lucasmarciano.iti_theme.typo.LocalLibFontSize
import com.lucasmarciano.iti_theme.typo.LocalLibType
import com.lucasmarciano.iti_theme.typo.Type

@Composable
fun ItiTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: ComposableAliasSimple) {
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

@Composable
private fun ProvideTheme(
    colors: IColorsStructure, content: ComposableAliasSimple
) {
    val colorPalette = remember { colors }
    CompositionLocalProvider(
        localLibColor(isSystemInDarkTheme()) provides colorPalette,
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
