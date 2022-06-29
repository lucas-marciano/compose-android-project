package com.lucasmarciano.core.utils

import androidx.compose.runtime.Composable

typealias ComposableAlias<T> = @Composable (T) -> Unit
typealias ComposableAliasSimple = @Composable () -> Unit
typealias OnEventClick<T> = (T) -> Unit
typealias OnEventClickSimple = () -> Unit
