package com.lucasmarciano.composeproject.utils.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope

internal fun Fragment.observerData(block: suspend CoroutineScope.() -> Unit) {
    this.viewLifecycleOwner.lifecycleScope.launchWhenResumed { block(this) }
}