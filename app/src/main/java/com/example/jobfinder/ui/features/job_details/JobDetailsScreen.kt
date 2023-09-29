package com.example.jobfinder.ui.features.job_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobfinder.ui.composables.ContentVisibility
import com.example.jobfinder.ui.composables.ErrorPlaceHolder
import com.example.jobfinder.ui.composables.Loading
import com.example.jobfinder.ui.features.job_details.composable.JobDetailsCard
import com.example.jobfinder.ui.theme.black60
import com.example.jobfinder.ui.theme.dimens

@Composable
fun JobDetailsScreen(
    viewModel: JobDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    JobDetailsContent(state)
}

@Composable
fun JobDetailsContent(
    state: JobDetailsUiState,
) {
    Loading(state = state.isLoading)
    ErrorPlaceHolder(state = state.isError)
    ContentVisibility(state = !state.isLoading && !state.isError) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JobDetailsCard(
                title = state.jobDetails.title,
                companyName = state.jobDetails.companyName,
                companyLogo = state.jobDetails.companyLogo,
                category = state.jobDetails.category,
                jobType = state.jobDetails.jobType,
                location = state.jobDetails.location,
                date = state.jobDetails.publishedDate
            )
            Text(
                text = "Description",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onSecondary,
                maxLines = 1,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis
            )
            LazyColumn(
                modifier = Modifier.padding(MaterialTheme.dimens.space16)
            ) {
                item {
                    Text(
                        text = state.jobDetails.description,
                        style = MaterialTheme.typography.displayMedium,
                        color = black60,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }





}