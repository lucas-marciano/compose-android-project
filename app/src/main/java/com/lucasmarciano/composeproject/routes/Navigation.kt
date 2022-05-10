package com.lucasmarciano.composeproject.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucasmarciano.composeproject.features.home.HomeScreen
import com.lucasmarciano.composeproject.features.settings.SettingsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) { HomeScreen(navController) }
        composable(route = Screen.SettingsScreen.route) { SettingsScreen(navController) }
    }
}
