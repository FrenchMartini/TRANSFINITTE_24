package com.example.transfinitte_24_ip_dapp.backend

import retrofit2.http.GET

interface Web3PatentClient {
    @GET("/register")
    suspend fun registerPatent()
}