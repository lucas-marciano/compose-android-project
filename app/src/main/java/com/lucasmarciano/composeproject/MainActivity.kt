package com.lucasmarciano.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasmarciano.composeproject.ui.components.Title
import com.lucasmarciano.composeproject.ui.components.WhiteToolbar
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import com.lucasmarciano.composeproject.ui.theme.HomeAvatar
import com.lucasmarciano.composeproject.ui.theme.StoreIcon

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = { WhiteToolbar(R.string.app_name) },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    ) {
                        HomeTitle()
                    }
                }
            )
        }
    }
}


@Composable
fun HomeTitle(
    name: String = stringResource(id = R.string.label_my_business),
    hasNotification: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HomeAvatar()
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Title(name)
            StoreIcon(hasNotification = hasNotification)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeTitlePreview() {
    ComposeProjectTheme {
        HomeTitle()
    }
}


@Preview(showBackground = true)
@Composable
fun HomeTitleWithNotificationPreview() {
    ComposeProjectTheme {
        HomeTitle(hasNotification = true)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainPreview() {
    ComposeProjectTheme {
        Scaffold(
            topBar = { WhiteToolbar(R.string.app_name) },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    HomeTitle()
                }
            }
        )
    }
}
