package com.android.nytimes_milansexercise.Utility

import okhttp3.ResponseBody

sealed class Resource<out T> {

    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(
        val networkError: Boolean?,
        val errorCode: Int?,
        val responseBody: ResponseBody?,
        val responseError: String? = null
    ): Resource<Nothing>()

}