package com.example.cryptolist.domain.use_cases

import com.example.cryptolist.domain.model.Coin
import com.example.cryptolist.domain.repository.CoinRepository
import com.example.cryptolist.utils.Response
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend fun execute(): Response<List<Coin>> {
        return coinRepository.getCoins()
    }

}
