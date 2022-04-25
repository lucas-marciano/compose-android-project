package com.lucasmarciano.composeproject.features.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.ui.components.WhiteToolbar
import com.lucasmarciano.composeproject.ui.theme.ComposeProjectTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : Fragment() {

    private val viewModel: SettingsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            ComposeProjectTheme {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.background,
                    topBar = { WhiteToolbar(R.string.title_settings) },
                    content = {
                        SettingsContent(viewModel.uiState.collectAsState().value)
                    }
                )
            }
        }
    }
}
