package com.example.jobfinder.ui.features.favorite

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobfinder.ui.navigation.Screen

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
) {
    FavoriteContent()


}

@Composable
fun FavoriteContent() {
    Text(text ="Favorite Scren")

}