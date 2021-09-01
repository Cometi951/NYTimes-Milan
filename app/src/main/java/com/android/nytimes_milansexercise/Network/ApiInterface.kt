package com.android.nytimes_milansexercise.Network

import com.android.nytimes_milansexercise.Constant.Constant.API_KEY
import com.android.nytimes_milansexercise.Data.DataArticle
import retrofit2.http.*

interface ApiInterface {

    @GET("viewed/7.json?api-key=${API_KEY}")
    suspend fun getArticles(): DataArticle

}