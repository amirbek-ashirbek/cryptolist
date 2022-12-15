package com.example.cryptolist.domain.repository

import com.example.cryptolist.domain.model.Coin
import com.example.cryptolist.domain.model.CoinDetails
import com.example.cryptolist.utils.Response

interface CoinRepository {

    suspend fun getCoins(): Response<List<Coin>>

    suspend fun getCoinDetailsById(coinId: String): Response<CoinDetails>
}