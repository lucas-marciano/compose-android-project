package com.lucasmarciano.composeproject.data.remote

import com.lucasmarciano.composeproject.data.home.response.HomeBuildResponse
import retrofit2.http.GET

interface ApiConnection {

    @GET("fetch-home")
    suspend fun fetchHomeData(): HomeBuildResponse
}