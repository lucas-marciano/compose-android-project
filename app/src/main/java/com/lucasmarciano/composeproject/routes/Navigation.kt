@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.lucasmarciano.composeproject.routes

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucasmarciano.composeproject.features.home.HomeScreen
import com.lucasmarciano.composeproject.features.sales.SalesScreen
import com.lucasmarciano.composeproject.features.settings.SettingsScreen
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        modifier = Modifier.background(
            ComposeProjectTheme.colors.bg
        )
    ) {
        composable(
            route = Screen.HomeScreen.route,
            enterTransition = { enterSlideTransition() },
            exitTransition = { exitSlideTransition(false) },
            popEnterTransition = { enterSlideTransition(false) },
            popExitTransition = { exitSlideTransition() },
        ) { HomeScreen(navController) }
        composable(
            route = Screen.SettingsScreen.route,
            enterTransition = { enterSlideTransition() },
            exitTransition = { exitSlideTransition(false) },
            popEnterTransition = { enterSlideTransition(false) },
            popExitTransition = { exitSlideTransition() },
        ) { SettingsScreen(navController) }
        composable(
            route = Screen.SalesScreen.route,
            enterTransition = { enterSlideTransition() },
            exitTransition = { exitSlideTransition(false) },
            popEnterTransition = { enterSlideTransition(false) },
            popExitTransition = { exitSlideTransition() },
        ) { SalesScreen(navController) }
    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun AnimatedContentScope<NavBackStackEntry>.enterSlideTransition(isLeft: Boolean = true): EnterTransition {
    val transitionDirection =
        if (isLeft) AnimatedContentScope.SlideDirection.Left else AnimatedContentScope.SlideDirection.Right
    return slideIntoContainer(transitionDirection, animationSpec = tween(700))
}

@OptIn(ExperimentalAnimationApi::class)
private fun AnimatedContentScope<NavBackStackEntry>.exitSlideTransition(isLeft: Boolean = true): ExitTransition {
    val transitionDirection =
        if (isLeft) AnimatedContentScope.SlideDirection.Left else AnimatedContentScope.SlideDirection.Right
    return slideOutOfContainer(transitionDirection, animationSpec = tween(700))
}
