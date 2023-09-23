package com.example.jobfinder.ui.features.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.jobfinder.ui.navigation.Screen

private val ROUTE =Screen.SearchScreen.route
fun NavController.navigateToSearchScreen(){
    navigate(ROUTE)
}
fun NavGraphBuilder.searchRoute(){
    composable(ROUTE){ SearchScreen()}
}