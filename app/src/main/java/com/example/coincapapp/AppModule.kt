package com.example.coincapapp

import com.example.coincapapp.services.CoinCapApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.InstallIn
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun ktorClient(): HttpClient {
        return HttpClient()
    }

    @Provides
    @Singleton
    fun coinCapService(client: HttpClient): CoinCapApiService {
        return CoinCapApiService(client)
    }


}