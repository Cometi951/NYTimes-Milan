package com.toneop.mobile.Di

import com.android.nytimes_milansexercise.Network.Api
import com.android.nytimes_milansexercise.Network.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi(remoteDataSource: Api): ApiInterface = remoteDataSource.retrofit

}