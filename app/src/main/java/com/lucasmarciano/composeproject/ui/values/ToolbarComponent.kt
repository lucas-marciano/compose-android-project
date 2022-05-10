package com.lucasmarciano.composeproject.ui.values

import com.lucasmarciano.composeproject.routes.Screen
import com.lucasmarciano.composeproject.ui.Components

internal data class ToolbarComponent(
    val title: String,
    val type: TypeToolbar = TypeToolbar.NORMAL,
    val backTo: String = Screen.HomeScreen.route,
    val contextualMenu: ToolbarContextualMenu = ToolbarContextualMenu.HELP
) : InterfaceItemComponent(Components.TOOLBAR)

enum class TypeToolbar {
    NORMAL,
    BLUE
}

enum class ToolbarContextualMenu {
    NONE,
    HELP
}