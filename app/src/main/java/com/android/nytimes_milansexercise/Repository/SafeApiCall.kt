package com.android.nytimes_milansexercise.Repository

import android.content.Context
import com.android.nytimes_milansexercise.Utility.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.FileNotFoundException
import java.net.SocketTimeoutException

interface SafeApiCall {
    suspend fun <T> safeApiCall(
        @ApplicationContext context: Context, apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                if (throwable is HttpException) {
                    Resource.Failure(false, throwable.code(), throwable.response()?.errorBody())
                } else if (throwable is SocketTimeoutException) {
                    Resource.Failure(false, 504, null)
                } else if (throwable is IllegalArgumentException) {
                    Resource.Failure(false, 505, null, throwable.message)
                } else if (throwable is FileNotFoundException) {
                    Resource.Failure(false, 506, null, throwable.message)
                } else {
                    Resource.Failure(true, null, null)
                }
            }
        }
    }
}