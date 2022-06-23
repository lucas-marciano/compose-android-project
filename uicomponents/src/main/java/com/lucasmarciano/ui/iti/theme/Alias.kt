package com.lucasmarciano.ui.iti.theme

import androidx.compose.runtime.Composable

typealias ComposableAliasSimple = @Composable () -> Unit
typealias ComposableAlias<T> = @Composable (T) -> Unit
