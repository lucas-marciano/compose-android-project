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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lucasmarciano.composeproject.utils.ComposableAliasSimple
import com.lucasmarciano.ui.iti.theme.colors.ColorsMainTheme
import com.lucasmarciano.ui.iti.theme.colors.DarkColorPalette
import com.lucasmarciano.ui.iti.theme.colors.LightColorPalette
import com.lucasmarciano.ui.iti.theme.colors.LocalLibColors
import com.lucasmarciano.ui.iti.theme.dimens.Elevation
import com.lucasmarciano.ui.iti.theme.dimens.LocalLibElevation
import com.lucasmarciano.ui.iti.theme.dimens.LocalLibSpacing
import com.lucasmarciano.ui.iti.theme.dimens.Spacing
import com.lucasmarciano.ui.iti.theme.typo.FontSize
import com.lucasmarciano.ui.iti.theme.typo.LocalLibFontSize
import com.lucasmarciano.ui.iti.theme.typo.LocalLibType
import com.lucasmarciano.ui.iti.theme.typo.Type

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
        @Composable get() = LocalLibColors.current

    val spacing: Spacing
        @Composable get() = LocalLibSpacing.current

    val elevation: Elevation
        @Composable get() = LocalLibElevation.current

    val fontSize: FontSize
        @Composable get() = LocalLibFontSize.current

    val type: Type
        @Composable get() = LocalLibType.current
}

@Composable
fun ProvideThemeColors(
    colors: ColorsMainTheme, content: ComposableAliasSimple
) {
    val colorPalette = remember { colors.copy() }
    colorPalette.update(colors)
    CompositionLocalProvider(
        LocalLibColors provides colorPalette,
        LocalLibType provides Type(),
        LocalLibSpacing provides Spacing(),
        LocalLibElevation provides Elevation(),
        LocalLibFontSize provides FontSize(),
        content = content
    )
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
