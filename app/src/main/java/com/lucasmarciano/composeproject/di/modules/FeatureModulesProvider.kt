package com.lucasmarciano.composeproject.di.modules

import com.lucasmarciano.composeproject.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    viewModel { HomeViewModel() }
}
