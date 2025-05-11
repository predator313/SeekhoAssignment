package com.example.seekhoassignment.di

import com.example.seekhoassignment.data.remote.PokeMonApi
import com.example.seekhoassignment.data.repository.PokeMonRepositoryImpl
import com.example.seekhoassignment.domain.repository.PokeMonRepository
import com.example.seekhoassignment.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokeMonModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun providePokeMonApi(client: OkHttpClient): PokeMonApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeMonApi::class.java)
    }


    @Provides
    @Singleton
    fun providePokeMonRepository(api: PokeMonApi): PokeMonRepository {
        return PokeMonRepositoryImpl(api = api)
    }
}