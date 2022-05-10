package com.lucasmarciano.composeproject.routes

sealed class Screen(val route: String, val data: Any? = null) {
    object HomeScreen : Screen("home_screen")
    object SettingsScreen : Screen("settings_screen")
    object BackToUp : Screen("")

    fun withArgs(vararg args: String) = buildString {
        append(route)
        args.forEach { arg -> append("/$arg") }
    }
}