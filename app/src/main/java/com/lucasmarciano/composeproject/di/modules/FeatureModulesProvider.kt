package com.lucasmarciano.composeproject.di.modules

import com.lucasmarciano.composeproject.data.home.repositories.HomeRepository
import com.lucasmarciano.composeproject.data.home.repositories.HomeRepositoryImpl
import com.lucasmarciano.composeproject.domain.home.HomeUseCase
import com.lucasmarciano.composeproject.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val featureModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get()) }
    single { HomeUseCase(get(), get(qualifier = named("IoDispatcher"))) }
    viewModel { HomeViewModel() }
}
