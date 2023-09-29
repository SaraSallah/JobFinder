package com.example.jobfinder.ui.features.home


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.jobfinder.ui.navigation.Screen

private val ROUTE =Screen.HomeScreen.route

fun NavController.navigateToHomeScreen(){
    navigate(ROUTE)
}
fun NavGraphBuilder.homeRoute(){
    composable(ROUTE){ HomeScreen()}
}

