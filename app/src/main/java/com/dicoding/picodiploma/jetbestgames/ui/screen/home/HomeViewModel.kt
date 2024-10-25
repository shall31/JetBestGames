package com.dicoding.picodiploma.jetbestgames.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.picodiploma.jetbestgames.data.GamesRepository
import com.dicoding.picodiploma.jetbestgames.model.Games
import com.dicoding.picodiploma.jetbestgames.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: GamesRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Games>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Games>>>
        get() = _uiState

    fun getAllRewards() {
        viewModelScope.launch {
            repository.getAllGames()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }
}