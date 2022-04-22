package com.lucasmarciano.composeproject.di.modules

import com.lucasmarciano.composeproject.data.remote.ApiConnection
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = ""

val remoteModules = module {
    single { retrofit(ApiConnection::class.java) }
}

private fun okHttp(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}

private fun retrofit(service: Class<ApiConnection>) = Retrofit.Builder()
    .callFactory(OkHttpClient.Builder().build())
    .baseUrl(BASE_URL)
    .client(okHttp())
    .addConverterFactory(GsonConverterFactory.create())
    .build().apply { create(service) }
