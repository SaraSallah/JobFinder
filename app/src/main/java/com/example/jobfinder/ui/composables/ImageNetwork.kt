package com.example.jobfinder.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jobfinder.R


@Composable
fun ImageNetwork(
    modifier: Modifier = Modifier,
    imageUrl: String,
    contentDescription: String = "",
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null
) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        alignment = Alignment.Center,
        error = painterResource(R.drawable.placeholder),
        colorFilter = colorFilter,
        placeholder = painterResource(R.drawable.placeholder),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier,
    )
}