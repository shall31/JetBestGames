package com.dicoding.picodiploma.jetbestgames.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.picodiploma.jetbestgames.data.GamesRepository
import com.dicoding.picodiploma.jetbestgames.model.Games
import com.dicoding.picodiploma.jetbestgames.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailGamesViewModel(
    private val repository: GamesRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Games>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Games>>
        get() = _uiState

    fun getGamesById(gamesId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderRewardById(gamesId))
        }
    }

}