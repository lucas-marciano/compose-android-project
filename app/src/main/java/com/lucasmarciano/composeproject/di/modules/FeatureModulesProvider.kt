package com.lucasmarciano.composeproject.di.modules

import com.lucasmarciano.composeproject.features.home.HomeViewModel
import com.lucasmarciano.composeproject.features.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    viewModel { HomeViewModel() }
    viewModel { SettingsViewModel() }
}
