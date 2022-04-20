package com.lucasmarciano.composeproject.data.home.repositories

import com.lucasmarciano.composeproject.data.home.response.HomeBuildResponse
import com.lucasmarciano.composeproject.data.remote.ApiConnection
import com.lucasmarciano.composeproject.data.remote.Result
import com.lucasmarciano.composeproject.data.remote.utils.makeFlowRequest
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(private val api: ApiConnection) : HomeRepository {
    override suspend fun fetchHomeData(): Flow<Result<HomeBuildResponse>> = makeFlowRequest {
        api.fetchHomeData()
    }
}