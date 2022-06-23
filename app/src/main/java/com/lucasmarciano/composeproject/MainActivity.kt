package com.lucasmarciano.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lucasmarciano.composeproject.routes.Navigation
import com.lucasmarciano.ui.iti.theme.ItiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItiTheme {
                Navigation()
            }
        }
    }
}
