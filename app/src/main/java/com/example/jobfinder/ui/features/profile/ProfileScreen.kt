package com.example.jobfinder.ui.features.profile

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProfileScreen(
     viewModel: ProfileViewModel = hiltViewModel()
) {
     ProfileContent()

}

@Composable
fun ProfileContent() {
     Text(text = "Profile Screen")

}

