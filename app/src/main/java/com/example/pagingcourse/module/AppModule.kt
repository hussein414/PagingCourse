package com.example.pagingcourse.module

import com.example.pagingcourse.data.api.ApiService
import com.example.pagingcourse.utils.Constance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseUrl() = Constance.base_url

    @Provides
    @Singleton
    fun providesRetrofitInstance(base_url: String): ApiService =
        Retrofit.Builder().baseUrl(base_url).
            addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
}