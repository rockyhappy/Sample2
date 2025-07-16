package com.devrachit.swiggy_com_imdb.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.devrachit.swiggy_com_imdb.presentation.screens.details.DetailViewmodel
import com.devrachit.swiggy_com_imdb.presentation.screens.details.DetailsScreen
import com.devrachit.swiggy_com_imdb.presentation.screens.list.ListScreen
import com.devrachit.swiggy_com_imdb.presentation.screens.list.ListScreenViewmodel

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = ScreenRoutes.HomeScreen.route
    ) {
        composable(ScreenRoutes.HomeScreen.route) {
            val viewmodel = hiltViewModel<ListScreenViewmodel>()
            ListScreen(
                viewmodel = viewmodel,
                navigateToDetail =
                    { movieId ->
                        navController.navigate(
                            ScreenRoutes.DetailScreen.createRoute(movieId = movieId)
                        )
                    }
            )

        }
        composable(route=ScreenRoutes.DetailScreen.routeWithArgs, arguments = listOf(
            navArgument ("movieId"){
                type = NavType.StringType
                defaultValue = "tt14961624"
                nullable = false
            }
        )) {backStackEntry->
            val movieId = backStackEntry.arguments?.getString("movieId")
            val viewmodel = hiltViewModel<DetailViewmodel>()
            DetailsScreen(
                movieId = movieId.toString(),
                viewModel = viewmodel,
            )
        }
    }
}