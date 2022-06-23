package com.lucasmarciano.ui.iti.utils

import androidx.compose.runtime.Composable

internal typealias ComposableAliasSimple = @Composable () -> Unit
internal typealias ComposableAlias<T> = @Composable (T) -> Unit