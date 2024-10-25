package com.dicoding.picodiploma.jetbestgames.data

import com.dicoding.picodiploma.jetbestgames.model.FakeGamesDataSource
import com.dicoding.picodiploma.jetbestgames.model.Games
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GamesRepository {

    private val games = mutableListOf<Games>()

    init {
        if (games.isEmpty()) {
            FakeGamesDataSource.dummyGames.forEach {
                games.add(it)
            }
        }
    }

    fun getAllGames(): Flow<List<Games>> {
        return flowOf(games)
    }

    fun getOrderRewardById(rewardId: Long): Games {
        return games.first {
            it.id == rewardId
        }
    }

    companion object {
        @Volatile
        private var instance: GamesRepository? = null

        fun getInstance(): GamesRepository =
            instance ?: synchronized(this) {
                GamesRepository().apply {
                    instance = this
                }
            }
    }
}