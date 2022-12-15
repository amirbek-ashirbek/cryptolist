package com.example.cryptolist.data.network

import com.example.cryptolist.data.network.model.CoinDetailsResponse
import com.example.cryptolist.data.network.model.CoinResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinResponse>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetailsById(
        @Path("coinId") coinId: String
    ): CoinDetailsResponse
}