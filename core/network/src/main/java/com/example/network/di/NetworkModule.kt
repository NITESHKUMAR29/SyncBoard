package com.example.network.di

import com.example.network.apiInterface.SyncBoardApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://taskflow-backend-wzjw.onrender.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    
    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): SyncBoardApi {
        return retrofit.create(SyncBoardApi::class.java)
    }
}

