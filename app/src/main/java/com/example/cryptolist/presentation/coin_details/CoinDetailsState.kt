package com.example.cryptolist.presentation.coin_details

import com.example.cryptolist.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error: String = ""
)
