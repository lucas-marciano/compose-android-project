package com.lucasmarciano.composeproject.data.remote.utils

import com.lucasmarciano.composeproject.data.remote.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import retrofit2.HttpException
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
internal suspend fun <T : Any> makeFlowRequest(
    dataSource: suspend () -> T?
): Flow<Result<T>> = channelFlow {
    run {
        send(Result.Loading)
        dataSource.invoke()
    }.let {
        send(Result.Success(it))
    }
}

internal suspend fun <T> makeSafeRequest(
    request: suspend () -> Response<T>
) = with(request) {
    val response = invoke()

    if (response.isSuccessful.not())
        throw HttpException(response)

    response.body()
}
