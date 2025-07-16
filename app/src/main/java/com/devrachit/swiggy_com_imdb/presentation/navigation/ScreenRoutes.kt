package com.devrachit.swiggy_com_imdb.presentation.navigation

sealed class ScreenRoutes(val route: String) {
    object HomeScreen : ScreenRoutes("home_screen")
    object DetailScreen : ScreenRoutes("detail_screen/{movieId}"){
        fun createRoute(movieId: String) = "detail_screen/$movieId"
        const val routeWithArgs = "detail_screen/{movieId}"
    }
}