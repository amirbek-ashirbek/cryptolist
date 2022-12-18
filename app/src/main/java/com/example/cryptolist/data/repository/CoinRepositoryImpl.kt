package com.example.cryptolist.data.repository

import com.example.cryptolist.data.network.CoinPaprikaApi
import com.example.cryptolist.data.network.model.CoinDetailsResponse.Companion.toCoinDetails
import com.example.cryptolist.data.network.model.CoinResponse.Companion.toCoin
import com.example.cryptolist.domain.model.Coin
import com.example.cryptolist.domain.model.CoinDetails
import com.example.cryptolist.domain.repository.CoinRepository
import com.example.cryptolist.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi,
) : CoinRepository {

    override suspend fun getCoins(): Flow<Response<List<Coin>>> = flow {
        emit(Response.Loading())
        try {
            val coins = api.getCoins().map { toCoin(it) }
            emit(Response.Success(coins))
        } catch (e: HttpException) {
            emit(Response.Error("An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Response.Error("Please, check your internet connection."))
        }
    }

    override suspend fun getCoinDetailsById(coinId: String): Flow<Response<CoinDetails>> = flow {
        emit(Response.Loading())
        try {
            val coin = toCoinDetails(api.getCoinDetailsById(coinId))
            emit(Response.Success(coin))
        } catch (e: HttpException) {
            emit(Response.Error("An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Response.Error("Please, check your internet connection."))
        }
    }

}