package com.example.jobfinder.ui.features.bottom_navigation

import com.example.jobfinder.R
import com.example.jobfinder.ui.navigation.Screen

sealed class BottomBarItems(
    val route: String,
    val label: Int,
    val icon: Int,
) {

    object Home : BottomBarItems(
        route = Screen.HomeScreen.route,
        label = R.string.home,
        icon = R.drawable.ic_home,
    )

    object Search : BottomBarItems(
        route = Screen.SearchScreen.route,
        label = R.string.search,
        icon = R.drawable.icon_search
    )

    object Favorite : BottomBarItems(
        route = Screen.FavoriteScreen.route,
        label = R.string.favorite,
        icon = R.drawable.home
    )

    object Profile : BottomBarItems(
        route = Screen.ProfileScreen.route,
        label = R.string.profile,
        icon = R.drawable.ic_person,
    )

}