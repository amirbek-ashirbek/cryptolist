package com.example.cryptolist.domain.use_cases

import com.example.cryptolist.domain.model.CoinDetails
import com.example.cryptolist.domain.repository.CoinRepository
import com.example.cryptolist.utils.Response
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
){
    suspend fun execute(coinId: String): Response<CoinDetails> {
        return coinRepository.getCoinDetailsById(coinId)
    }
}