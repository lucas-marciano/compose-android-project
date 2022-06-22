package com.lucasmarciano.composeproject.utils

import androidx.compose.runtime.Composable

typealias ComposableAliasSimple = @Composable () -> Unit
typealias ComposableAlias<T> = @Composable (T) -> Unit
