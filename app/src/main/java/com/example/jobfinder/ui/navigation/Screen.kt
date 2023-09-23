package com.example.jobfinder.ui.navigation

sealed class Screen(val route :String){

    object OnBoarding :Screen ("onBoarding")
    object HomeScreen :Screen ("homeScreen")
    object ProfileScreen  :Screen("profileScreen")
    object FavoriteScreen : Screen ("favoriteScreen")
    object SearchScreen :Screen ("searchScreen")
    object JobDetailsScreen :Screen("jobDetailsScreen")
}
