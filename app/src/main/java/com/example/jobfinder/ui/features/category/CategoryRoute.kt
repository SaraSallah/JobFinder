package com.example.jobfinder.ui.features.category

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.jobfinder.ui.features.home.HomeScreen
import com.example.jobfinder.ui.navigation.Screen


private val ROUTE = Screen.CategoryScreen.route

fun NavController.navigateToCategoryScreen(){
    navigate(ROUTE)
}
fun NavGraphBuilder.categoryRoute(){
    composable(ROUTE){ (CategoryScreen()) }
}