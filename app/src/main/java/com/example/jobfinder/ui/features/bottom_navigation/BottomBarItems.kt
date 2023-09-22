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
    icon =R.drawable.home,
)
object Profile : BottomBarItems(
    route = Graph.Profile ,
    label = R.string.profile ,
    icon = R.drawable.ic_person ,
)
object Search :BottomBarItems(
    route = Graph.Search ,
    label =R.string.search ,
    icon = 3
)