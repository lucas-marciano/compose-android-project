package com.lucasmarciano.composeproject.domain

import com.lucasmarciano.composeproject.remote.Result
import com.lucasmarciano.composeproject.utils.extensions.toException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

internal abstract class SimpleFlowUseCase<R>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend fun invoke(): Flow<Result<R>> = execute()
        .flowOn(coroutineDispatcher)
        .catch {
            emit(Result.Error(it.toException()))
        }

    protected abstract suspend fun execute(): Flow<Result<R>>
}