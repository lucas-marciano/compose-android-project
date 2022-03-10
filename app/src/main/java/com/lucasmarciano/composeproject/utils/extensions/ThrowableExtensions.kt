package com.lucasmarciano.composeproject.utils.extensions

fun Throwable.toException() = if (this is Exception) this else Exception(this)
