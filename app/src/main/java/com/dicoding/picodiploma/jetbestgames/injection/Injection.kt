package com.dicoding.picodiploma.jetbestgames.injection

import com.dicoding.picodiploma.jetbestgames.data.GamesRepository

object Injection {
    fun provideRepository(): GamesRepository {
        return GamesRepository.getInstance()
    }
}