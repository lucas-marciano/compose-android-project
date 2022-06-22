package com.lucasmarciano.composeproject.routes

private const val KEY_SALE_ID = "sale_id"

sealed class Screen(private val route: String, private val argName: List<String> = emptyList()) {
    object HomeScreen : Screen("home_screen_route")
    object SettingsScreen : Screen("settings_screen_route")
    object SalesScreen : Screen("sales_screen_route")
    object DetailSale : Screen("detail_sale_screen_route", listOf(KEY_SALE_ID)) {
        const val KEY_SALE_ID = "sale_id"
    }

    fun mountPathWithArgs(vararg args: String) = buildString {
        append(route)
        args.forEach { arg -> append("/{$arg}") }
    }

    fun buildPath() = buildString {
        append(route)
        if (argName.isNotEmpty()) {
            argName.forEach { arg -> append("/{$arg}") }
        }
    }
}