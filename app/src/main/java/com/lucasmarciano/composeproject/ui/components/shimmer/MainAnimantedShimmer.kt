package com.lucasmarciano.composeproject.ui.components.shimmer

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.lucasmarciano.composeproject.utils.ComposableAlias

object MainAnimatedShimmer {

    val brushColors = Brush.linearGradient(
        listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f),
        )
    )

    @Composable
    fun ShimmerView(
        isLoading: Boolean = true,
        content: ComposableAlias,
        contentShimmer: @Composable (Brush) -> Unit
    ) {
        val currentPage by remember { mutableStateOf(isLoading) }
        val brush = configAnimatedShimmer()
        Crossfade(targetState = currentPage) { screen ->
            when (screen) {
                true -> contentShimmer(brush)
                else -> content()
            }
        }
    }

    @Composable
    private fun configAnimatedShimmer(): Brush {
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f),
        )
        val transition = rememberInfiniteTransition()
        val translateAnim = transition.animateFloat(
            initialValue = INITIAL_VALUE,
            targetValue = TARGET_VALUE,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = ANIMATION_DURATION_VALUE,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        return Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnim.value, y = translateAnim.value)
        )
    }

    private const val INITIAL_VALUE = 0f
    private const val TARGET_VALUE = 1000f
    private const val ANIMATION_DURATION_VALUE = 1300
}
