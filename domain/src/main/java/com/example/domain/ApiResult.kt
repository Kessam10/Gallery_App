package com.example.domain

sealed interface ApiResult<T> {
    class Loading<T> : ApiResult<T>
    data class Error<T>(val errorMsg:String): ApiResult<T>
    data class Success<T>(val data: T): ApiResult<T>
}