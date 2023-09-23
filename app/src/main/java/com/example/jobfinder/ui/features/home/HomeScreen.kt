package com.example.jobfinder.ui.features.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    HomeContent(
        state = state ,
        listener = viewModel
    )

}

@Composable
fun HomeContent(
    state : HomeUiState ,
    listener: HomeInteractionListener
) {

}