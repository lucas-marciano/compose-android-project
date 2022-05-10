package com.lucasmarciano.composeproject.routes

sealed class Screen(val route: String, val data: Any? = null) {
    object HomeScreen : Screen("home_screen_route")
    object SettingsScreen : Screen("settings_screen_route")

    fun withArgs(vararg args: String) = buildString {
        append(route)
        args.forEach { arg -> append("/$arg") }
    }
}