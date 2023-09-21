package com.example.jobfinder.ui.features.bottom_navigation

import com.example.jobfinder.R
import com.example.jobfinder.ui.navigation.Graph

sealed class BottomBarItems(
    val route: String,
    val label: Int,
    val icon: Int,
)
object Home : BottomBarItems(
    route =Graph.Home ,
    label = R.string.home,
    icon =3
)
object Profile : BottomBarItems(
    route = Graph.Profile ,
    label = R.string.profile ,
    icon = 5 ,
)
object Search :BottomBarItems(
    route = Graph.Search ,
    label =R.string.search ,
    icon = 3
)