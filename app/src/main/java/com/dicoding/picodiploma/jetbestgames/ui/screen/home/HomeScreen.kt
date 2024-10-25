package com.dicoding.picodiploma.jetbestgames.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dicoding.picodiploma.jetbestgames.MyTopAppBar
import com.dicoding.picodiploma.jetbestgames.injection.Injection
import com.dicoding.picodiploma.jetbestgames.model.Games
import com.dicoding.picodiploma.jetbestgames.ui.ViewModelFactory
import com.dicoding.picodiploma.jetbestgames.ui.common.UiState
import com.dicoding.picodiploma.jetbestgames.ui.components.GamesItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
    navController: NavController
) {
    Column() {
        MyTopAppBar(navController)
        viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getAllRewards()
                }
                is UiState.Success -> {
                    HomeContent(
                        orderGames = uiState.data,
                        modifier = modifier,
                        navigateToDetail = navigateToDetail,
                    )
                }
                is UiState.Error -> {}
            }
        }

    }

}

@Composable
fun HomeContent(
    orderGames: List<Games>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(orderGames) { data ->
            GamesItem(
                image = data.image,
                title = data.title,
                modifier = Modifier.clickable {
                    navigateToDetail(data.id)
                }
            )
        }
    }
}