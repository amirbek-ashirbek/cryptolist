package com.example.cryptolist.domain.repository

import com.example.cryptolist.domain.model.Coin
import com.example.cryptolist.domain.model.CoinDetails
import com.example.cryptolist.utils.Response
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins(): Flow<Response<List<Coin>>>

    suspend fun getCoinDetailsById(coinId: String): Flow<Response<CoinDetails>>
}