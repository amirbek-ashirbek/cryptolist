package com.example.cryptolist.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptolist.domain.use_cases.GetCoinsUseCase
import com.example.cryptolist.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _uiState = mutableStateOf(CoinListState())
    val uiState: State<CoinListState> = _uiState

    init {
        viewModelScope.launch {
            getCoins()
        }
    }

    private suspend fun getCoins() {
        viewModelScope.launch {
            val result = getCoinsUseCase.execute()

            when (result) {
                is Response.Success -> {
                    _uiState.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Response.Error -> {
                    _uiState.value = CoinListState(error = result.errorMessage ?: "An unexpected error occurred.")
                }
                is Response.Loading -> {
                    _uiState.value = CoinListState(isLoading = true)
                }
            }
        }
    }

}