package com.example.cryptolist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptolist.presentation.coin_details.CoinDetailsScreen
import com.example.cryptolist.presentation.coin_list.CoinListScreen
import com.example.cryptolist.presentation.ui.theme.CryptoListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoListApp()
        }
    }
}

@Composable
fun CryptoListApp() {
    CryptoListTheme {
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            CryptoListNavHost(
                navController = navController
            )
        }
    }
}

@Composable
fun CryptoListNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = CoinListScreen.route,
        modifier = modifier
    ) {
        composable(route = CoinListScreen.route) {
            CoinListScreen(navController = navController)
        }
        composable(
            route = CoinDetailsScreen.routeWithArgs,
            ) {
                CoinDetailsScreen()
            }
    }
}