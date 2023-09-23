package com.example.jobfinder.ui.features.bottom_navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jobfinder.ui.navigation.Screen
import com.example.jobfinder.ui.theme.black60
import com.example.jobfinder.ui.theme.white

val LocalNavigationProvider = staticCompositionLocalOf<NavHostController> {
    error("No navigation host controller provided.")
}

@Composable
fun BottomBarUi(bottomNavState: MutableState<Boolean>) {
    val navController = LocalNavigationProvider.current
    val screens = listOf(
        BottomBarItems.Home,
        BottomBarItems.Search,
        BottomBarItems.Favorite,
        BottomBarItems.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    AnimatedVisibility(
        visible = bottomNavState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.onTertiary,
                tonalElevation = 0.dp,
            ) {
                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController,
                    )
                }
            }
        }
    )
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarItems,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    NavigationBarItem(
        selected = selected,
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "",
                tint = if (selected) white else MaterialTheme.colorScheme.outlineVariant

            )
        },
        label = {
            Text(
                text = if (selected) stringResource(id = screen.label) else "",
                color = MaterialTheme.colorScheme.onErrorContainer
            )
        },
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
            when (screen) {
                BottomBarItems.Home -> {
                    navController.popBackStack(Screen.HomeScreen.route, false)
                }

                BottomBarItems.Search -> navController.popBackStack(
                    Screen.SearchScreen.route,
                    false
                )

                BottomBarItems.Favorite -> navController.popBackStack(
                    Screen.FavoriteScreen.route,
                    false
                )

                BottomBarItems.Profile -> navController.popBackStack(
                    Screen.ProfileScreen.route,
                    false
                )
            }
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = white,
            indicatorColor = MaterialTheme.colorScheme.errorContainer,
            unselectedIconColor = black60
        )
    )

}
