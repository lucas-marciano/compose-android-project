package com.lucasmarciano.composeproject.data.home.repositories

import com.lucasmarciano.composeproject.data.home.response.HomeBuildResponse
import com.lucasmarciano.composeproject.remote.Result
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun fetchHomeData(): Flow<Result<HomeBuildResponse>>
}