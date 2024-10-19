package com.example.transfinitte_24_ip_dapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWeb3j(): Web3j {
        return Web3j.build(HttpService("https://sepolia.infura.io/v3/563f3d565c694d9983e98b8eeb70b62d"))
    }

}