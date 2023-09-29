package com.example.jobfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jobfinder.ui.features.bottom_navigation.BottomBarUi
import com.example.jobfinder.ui.features.bottom_navigation.LocalNavigationProvider
import com.example.jobfinder.ui.navigation.MainNavGraph
import com.example.jobfinder.ui.navigation.Screen
import com.example.jobfinder.ui.theme.JobFinderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {
                JobFinderTheme {
                    val bottomNavState = checkBottomBarState()
                    Scaffold(
                        bottomBar = {
                            BottomBarUi(bottomNavState)
                        },
                        contentWindowInsets = WindowInsets(0, 0, 0, 0)
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .fillMaxSize()
                                .padding(innerPadding)
                        )
                        { MainNavGraph() }
                    }
                }


            }
        }
    }
}

@Composable
private fun checkBottomBarState(): MutableState<Boolean> {
    val navController = LocalNavigationProvider.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    val bottomBarScreens = listOf(
        Screen.HomeScreen.route,
        Screen.SearchScreen.route,
        Screen.FavoriteScreen.route,
        Screen.ProfileScreen.route,

        )
    when (navBackStackEntry?.destination?.route) {
        in bottomBarScreens -> {
            // Show BottomBar
            bottomBarState.value = true
        }

        else -> {
            // Hide BottomBar
            bottomBarState.value = false
        }
    }
    return bottomBarState
}