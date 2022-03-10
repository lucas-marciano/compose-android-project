package com.lucasmarciano.composeproject.domain.home

import com.lucasmarciano.composeproject.data.home.mapper.mapToVO
import com.lucasmarciano.composeproject.data.home.models.HomeBuildVO
import com.lucasmarciano.composeproject.data.home.repositories.HomeRepository
import com.lucasmarciano.composeproject.domain.SimpleFlowUseCase
import com.lucasmarciano.composeproject.remote.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import java.security.InvalidParameterException

@OptIn(ExperimentalCoroutinesApi::class)
internal class HomeUseCase(
    private val repository: HomeRepository,
    coroutineDispatcher: CoroutineDispatcher
) : SimpleFlowUseCase<HomeBuildVO>(coroutineDispatcher) {
    override suspend fun execute(): Flow<Result<HomeBuildVO>> {
        return repository.fetchHomeData().mapLatest { result ->
            when (result) {
                is Result.Success -> {
                    result.data?.let {
                        Result.Success(it.mapToVO())
                    } ?: Result.Error(InvalidParameterException("do not have"))
                }
                is Result.Loading -> result
                is Result.Error -> result
            }
        }
    }

}