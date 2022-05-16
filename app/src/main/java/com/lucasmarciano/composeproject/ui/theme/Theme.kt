package com.lucasmarciano.composeproject.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
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

private val DarkColorScheme = darkColors(
    primary = Color(0xFF1C1B1F),
    primaryVariant = Color(0xFF444444),
    secondary = Color(0xFF1C1B1F),
    background = Color(0xFF1C1B1F),
    surface = Color(0xFF1C1B1F),
    error = Color(0xFFF44336),
    onPrimary = Color(0xFFFFFBFE),
    onSecondary = Color(0xFFFFFBFE),
    onBackground = Color(0xFFFFFBFE),
    onSurface = Color(0xFFFFFBFE),
    onError = Color(0xFFFFFFFF),
)

private val LightColorScheme = lightColors(
    primary = Color(0xFFFFFBFE),
    primaryVariant = Color(0xFFFFFBFE).copy(alpha = 0.7f),
    secondary = Color(0xFFFFFBFE),
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFE8E2E6),
    error = Color(0xFFF44336),
    onPrimary = Color(0xFF1C1B1F),
    onSecondary = Color(0xFF1C1B1F),
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0x401C1B1F),
    onError = Color(0x401C1B1F),
)

@Composable
fun ComposeProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
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