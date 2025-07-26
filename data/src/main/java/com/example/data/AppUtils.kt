package com.example.data

import com.example.data.utils.handleError
import com.example.domain.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun <T> executeAPI(api: suspend ()->T): Flow<ApiResult<T>> = flow {
    try {
        emit(ApiResult.Loading())
        val response = api.invoke()
        emit(ApiResult.Success(response))
    } catch (e:Exception){
        emit(ApiResult.Error(handleError(e).message?:""))
    }
}