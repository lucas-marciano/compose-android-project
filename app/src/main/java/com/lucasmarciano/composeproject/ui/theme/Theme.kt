@file:Suppress("DEPRECATION")

package com.lucasmarciano.composeproject.ui.theme

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
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lucasmarciano.composeproject.ui.utils.LocalType
import com.lucasmarciano.composeproject.ui.utils.Type
import com.lucasmarciano.composeproject.utils.ComposableAliasSimple
import com.lucasmarciano.ui.iti.theme.colors.ColorsMainTheme
import com.lucasmarciano.ui.iti.theme.colors.DarkColorPalette
import com.lucasmarciano.ui.iti.theme.colors.LightColorPalette
import com.lucasmarciano.ui.iti.theme.dimens.Elevation
import com.lucasmarciano.ui.iti.theme.dimens.LibElevation
import com.lucasmarciano.ui.iti.theme.dimens.LibSpacing
import com.lucasmarciano.ui.iti.theme.dimens.Spacing
import com.lucasmarciano.ui.iti.theme.fonts.FontSize
import com.lucasmarciano.ui.iti.theme.fonts.LibFontSize

@Composable
fun ComposeProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: ComposableAliasSimple
) {
    val colorScheme = when {
        darkTheme -> DarkColorPalette
        else -> LightColorPalette
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

    ProvideThemeColors(colorScheme) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = debugType(),
            shapes = Shapes(),
            content = content
        )
    }
}

object ComposeProjectTheme {
    val colors: ColorsMainTheme
        @Composable get() = LocalColors.current

    val spacing: Spacing
        @Composable get() = LibSpacing.current

    val elevation: Elevation
        @Composable get() = LibElevation.current

    val fontSize: FontSize
        @Composable get() = LibFontSize.current

    val type: Type
        @Composable get() = LocalType.current
}

@Composable
fun ProvideThemeColors(
    colors: ColorsMainTheme, content: ComposableAliasSimple
) {
    val colorPalette = remember { colors.copy() }
    colorPalette.update(colors)
    CompositionLocalProvider(
        LocalColors provides colorPalette,
        LocalType provides Type(),
        LibSpacing provides Spacing(),
        LibElevation provides Elevation(),
        LibFontSize provides FontSize(),
        content = content
    )
}

private val LocalColors = staticCompositionLocalOf<ColorsMainTheme> {
    error("No ColorPalette provided")
}

fun debugColors(darkTheme: Boolean, debugColor: Color = Color.Magenta) = Colors(
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

fun debugType() = Typography()
