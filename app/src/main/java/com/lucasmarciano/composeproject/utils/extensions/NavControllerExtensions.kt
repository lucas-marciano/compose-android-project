package com.lucasmarciano.composeproject.utils.extensions

import androidx.navigation.NavController

fun NavController.navBackTo(path: String?) {
    path?.let {
        this.navigate(path) {
            popUpTo(path) { inclusive = true }
        }
    }
}

fun NavController.navTo(path: String?) {
    path?.let { this.navigate(path) }
}
