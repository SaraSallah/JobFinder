package com.example.jobfinder.ui.features.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.jobfinder.ui.navigation.Screen

private val ROUTE =Screen.ProfileScreen.route

fun NavController.navigateToProfileScreen(){
    navigate(ROUTE)
}
fun NavGraphBuilder.profileRoute(){
    composable(ROUTE){ ProfileScreen()}
}