@file:Suppress("DEPRECATION")

package com.lucasmarciano.composeproject.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
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

private val DarkColorPalette = MainThemeColors(
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
    isDark = true
)

private val LightColorPalette = MainThemeColors(
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
    isDark = false
)

@Composable
fun ComposeProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: ComposableAlias
) {
    val colorScheme = when {
        darkTheme -> DarkColorPalette
        else -> LightColorPalette
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

    ProvideThemeColors(colorScheme) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = Typography,
            shapes = Shapes(),
            content = content
        )
    }
}

object ComposeProjectTheme {
    val colors: MainThemeColors
        @Composable
        get() = LocalColors.current
}

@Stable
class MainThemeColors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    isDark: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var primaryVariant by mutableStateOf(primaryVariant)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var background by mutableStateOf(background)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var onError by mutableStateOf(onError)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var error by mutableStateOf(error)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: MainThemeColors) {
        primary = other.primary
        primaryVariant = other.primaryVariant
        secondary = other.secondary
        background = other.background
        surface = other.surface
        onPrimary = other.onPrimary
        onSecondary = other.onSecondary
        onBackground = other.onBackground
        onSurface = other.onSurface
        onError = other.onError
        error = other.error
        isDark = other.isDark
    }

    fun copy(): MainThemeColors = MainThemeColors(
        primary = primary,
        primaryVariant = primaryVariant,
        secondary = secondary,
        background = background,
        surface = surface,
        onPrimary = onPrimary,
        onSecondary = onSecondary,
        onBackground = onBackground,
        onSurface = onSurface,
        onError = onError,
        error = error,
        isDark = isDark,
    )
}

@Composable
fun ProvideThemeColors(
    colors: MainThemeColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors.copy() }
    colorPalette.update(colors)
    CompositionLocalProvider(
        LocalColors provides colorPalette,
        LocalSpacing provides Spacing(),
        LocalElevation provides Elevation(),
        LocalFontSize provides FontSize(),
        content = content
    )
}

private val LocalColors = staticCompositionLocalOf<MainThemeColors> {
    error("No ColorPalette provided")
}

fun debugColors(darkTheme: Boolean, debugColor: Color = Color.Gray) = Colors(
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
