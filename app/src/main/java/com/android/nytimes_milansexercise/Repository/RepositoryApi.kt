package com.android.nytimes_milansexercise.Repository

import android.content.Context
import com.android.nytimes_milansexercise.Network.ApiInterface
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RepositoryApi @Inject constructor(@ApplicationContext val context: Context, val apiInterface: ApiInterface) : SafeApiCall {
    suspend fun articles() = safeApiCall(context) { apiInterface.getArticles() }
}
