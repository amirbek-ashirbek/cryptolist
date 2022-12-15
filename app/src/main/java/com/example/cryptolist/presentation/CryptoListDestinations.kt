package com.example.cryptolist.presentation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface CryptoListDestination {
    val route: String
}

object CoinListScreen: CryptoListDestination {
    override val route = "coin_list"
}

object CoinDetailsScreen: CryptoListDestination {
    override val route = "coin_details"
    const val routeWithArgs = "coin_details/{coinId}"
    val arguments = listOf(
        navArgument("coinId") { type = NavType.StringType }
    )
}