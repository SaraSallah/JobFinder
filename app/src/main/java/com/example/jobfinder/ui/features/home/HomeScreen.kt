package com.example.jobfinder.ui.features.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeContent()

}

@Composable
fun HomeContent() {
    Text("Home Screen")

}