package com.dicoding.picodiploma.jetbestgames.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.picodiploma.jetbestgames.data.GamesRepository
import com.dicoding.picodiploma.jetbestgames.ui.screen.detail.DetailGamesViewModel
import com.dicoding.picodiploma.jetbestgames.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: GamesRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailGamesViewModel::class.java)) {
            return DetailGamesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}