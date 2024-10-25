package com.dicoding.picodiploma.jetbestgames

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dicoding.picodiploma.jetbestgames.ui.navigation.Screen
import com.dicoding.picodiploma.jetbestgames.ui.screen.detail.DetailScreen
import com.dicoding.picodiploma.jetbestgames.ui.screen.home.HomeScreen
import com.dicoding.picodiploma.jetbestgames.ui.screen.screen.ProfileScreen
import com.dicoding.picodiploma.jetbestgames.ui.theme.JetBestGamesTheme

@Composable
fun JetBestGamesApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { rewardId ->
                        navController.navigate(Screen.DetailReward.createRoute(rewardId))
                    },
                    navController = navController
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailReward.route,
                arguments = listOf(navArgument("rewardId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("rewardId") ?: -1L
                DetailScreen(
                    rewardId = id,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun JetBestGamesAppPreview() {
    JetBestGamesTheme {
        JetBestGamesApp()
    }
}