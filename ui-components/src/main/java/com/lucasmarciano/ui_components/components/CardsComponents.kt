package com.lucasmarciano.ui_components.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lucasmarciano.core.utils.ComposableAliasSimple
import com.lucasmarciano.core.utils.emptyString

@Composable
internal fun CardMainStructure(
    modifier: Modifier = Modifier,
    isExpandable: Boolean = false,
    icon: String? = null,
    title: String = emptyString(),
    titleColor: Color = Color.Black,
    iconColor: Color = Color.Black,
    iconSize: Dp = 24.dp,
    padding: Dp = 16.dp,
    component: ComposableAliasSimple = {}
) {
    var isVisible by remember { mutableStateOf(isExpandable.not()) }

    val arrowIcon = produceState(initialValue = Icons.Outlined.ExpandMore, isVisible) {
        value = if (isVisible) Icons.Outlined.ExpandLess else Icons.Outlined.ExpandMore
    }

    Card {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(if (title.isNotEmpty()) padding else 0.dp)
                    .clickable(onClick = { if (isExpandable) isVisible = !isVisible }),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(verticalAlignment = Alignment.Top) {
                    icon?.let {
                        Icon(
                            modifier = Modifier.size(iconSize),
                            imageVector = Icons.Filled.CreditCard, //put a icon font
                            contentDescription = emptyString(),
                            tint = iconColor
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Text(text = title, color = titleColor)
                }
                if (isExpandable) {
                    Icon(
                        modifier = Modifier.size(iconSize),
                        imageVector = arrowIcon.value,
                        contentDescription = emptyString(),
                        tint = titleColor
                    )
                }
            }

            AnimatedVisibility(
                modifier = modifier.fillMaxWidth(),
                visible = isVisible
            ) {
                Surface(
                    modifier = modifier.fillMaxWidth(),
                    content = component
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardMainStructurePreview() {
    CardMainStructure(
        title = "title preview",
        isExpandable = true,
    ) {
        Text(modifier = Modifier.padding(16.dp), text = "body item")
    }
}
