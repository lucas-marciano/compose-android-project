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
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucasmarciano.composeproject.features.detailsale.DetailSaleScreen
import com.lucasmarciano.composeproject.features.home.HomeScreen
import com.lucasmarciano.composeproject.features.sales.SalesScreen
import com.lucasmarciano.composeproject.features.settings.SettingsScreen
import com.lucasmarciano.composeproject.routes.Screen.DetailSale.KEY_SALE_ID
import com.lucasmarciano.iti_theme.ItiTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.buildPath(),
        modifier = Modifier.background(
            ItiTheme.colors.bg
        )
    ) {
        composable(
            route = Screen.HomeScreen.buildPath(),
            enterTransition = { enterSlideTransition() },
            exitTransition = { exitSlideTransition(false) },
            popEnterTransition = { enterSlideTransition(false) },
            popExitTransition = { exitSlideTransition() },
        ) { HomeScreen(navController) }
        composable(
            route = Screen.SettingsScreen.buildPath(),
            enterTransition = { enterSlideTransition() },
            exitTransition = { exitSlideTransition(false) },
            popEnterTransition = { enterSlideTransition(false) },
            popExitTransition = { exitSlideTransition() },
        ) { SettingsScreen(navController) }
        composable(
            route = Screen.SalesScreen.buildPath(),
            enterTransition = { enterSlideTransition() },
            exitTransition = { exitSlideTransition(false) },
            popEnterTransition = { enterSlideTransition(false) },
            popExitTransition = { exitSlideTransition() },
        ) { SalesScreen(navController) }
        composable(route = Screen.DetailSale.buildPath(),
            enterTransition = { enterSlideTransition() },
            exitTransition = { exitSlideTransition(false) },
            popEnterTransition = { enterSlideTransition(false) },
            popExitTransition = { exitSlideTransition() },
            arguments = listOf(navArgument(KEY_SALE_ID) {
                type = NavType.StringType
                defaultValue = null
                nullable = true
            })) { entry ->
            DetailSaleScreen(
                entry.arguments?.getString(KEY_SALE_ID),
                navController
            )
        }
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
