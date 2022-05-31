@file:Suppress("DEPRECATION")

package com.lucasmarciano.composeproject.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lucasmarciano.composeproject.ui.utils.Elevation
import com.lucasmarciano.composeproject.ui.utils.FontSize
import com.lucasmarciano.composeproject.ui.utils.LocalElevation
import com.lucasmarciano.composeproject.ui.utils.LocalFontSize
import com.lucasmarciano.composeproject.ui.utils.LocalSpacing
import com.lucasmarciano.composeproject.ui.utils.Spacing
import com.lucasmarciano.composeproject.utils.ComposableAlias

private val DarkColorScheme = darkColors(
    primary = ColorDarkPrimary,
    primaryVariant = ColorDarkPrimaryVariant,
    secondary = ColorDarkSecondary,
    background = ColorDarkBackground,
    surface = ColorDarkSurface,
    error = ColorDarkError,
    onPrimary = ColorDarkOnPrimary,
    onSecondary = ColorDarkOnSecondary,
    onBackground = ColorDarkOnBackground,
    onSurface = ColorDarkOnSurface,
    onError = ColorDarkOnError,
)

private val LightColorScheme = lightColors(
    primary = ColorPrimary,
    primaryVariant = ColorPrimaryVariant,
    secondary = ColorSecondary,
    background = ColorBackground,
    surface = ColorSurface,
    error = ColorError,
    onPrimary = ColorOnPrimary,
    onSecondary = ColorOnSecondary,
    onBackground = ColorOnBackground,
    onSurface = ColorOnSurface,
    onError = ColorOnError,
)

@Composable
fun ComposeProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: ComposableAlias
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current

    val systemUiController = rememberSystemUiController()

    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
            systemUiController.setSystemBarsColor(
                color = colorScheme.primary,
                darkIcons = darkTheme.not()
            )
        }
    }

    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalElevation provides Elevation(),
        LocalFontSize provides FontSize(),
    ) {
        MaterialTheme(
            colors = colorScheme,
            typography = Typography,
            content = content
        )
    }
}