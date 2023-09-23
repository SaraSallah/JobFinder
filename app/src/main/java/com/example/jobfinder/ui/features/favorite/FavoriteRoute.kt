package com.example.jobfinder.ui.features.favorite

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.jobfinder.ui.navigation.Screen

private val ROUTE =Screen.FavoriteScreen.route
fun NavHostController.navigateToFavoriteScreen(){
    navigate(ROUTE)
}
fun NavGraphBuilder.favoriteRoute() {
    composable(ROUTE) { FavoriteScreen() }
}
