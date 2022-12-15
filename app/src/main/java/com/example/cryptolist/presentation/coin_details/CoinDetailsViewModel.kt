package com.example.cryptolist.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptolist.domain.use_cases.GetCoinDetailsUseCase
import com.example.cryptolist.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = mutableStateOf(CoinDetailsState())
    val uiState: State<CoinDetailsState> = _uiState

    init {
        savedStateHandle.get<String>("coinId")?.let { coinId ->
            getCoinDetails(coinId)
        }
    }

    private fun getCoinDetails(coinId: String) {
        viewModelScope.launch {
            val result = getCoinDetailsUseCase.execute(coinId)

            when (result) {
                is Response.Success -> {
                    _uiState.value = CoinDetailsState(coinDetails = result.data)
                }
                is Response.Error -> {
                    _uiState.value = CoinDetailsState(
                        error = result.errorMessage ?: "An unexpected error occurred."
                    )
                }
                is Response.Loading -> {
                    _uiState.value = CoinDetailsState(isLoading = true)
                }
            }
        }
    }

}