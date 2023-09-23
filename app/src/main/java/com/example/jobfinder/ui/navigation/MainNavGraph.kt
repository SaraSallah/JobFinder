package com.example.jobfinder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.jobfinder.ui.features.bottom_navigation.LocalNavigationProvider
import com.example.jobfinder.ui.features.favorite.favoriteRoute
import com.example.jobfinder.ui.features.home.homeRoute
import com.example.jobfinder.ui.features.profile.profileRoute
import com.example.jobfinder.ui.features.search.searchRoute

@Composable
fun MainNavGraph(){
    val navController = LocalNavigationProvider.current
    NavHost(navController
    = navController,
        startDestination = Screen.HomeScreen.route){
        homeRoute()
        searchRoute()
        favoriteRoute()
        profileRoute()
    }
} 
    


