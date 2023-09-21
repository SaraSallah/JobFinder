package com.example.jobfinder.ui.features.job_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobfinder.ui.composables.CompanyCard
import com.example.jobfinder.ui.composables.ContentVisibility
import com.example.jobfinder.ui.composables.Loading

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
    ContentVisibility(state = !state.isLoading && !state . isError) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {


            CompanyCard(
                imageUrl = state.jobDetails.companyLogo,
                jobTitle = state.jobDetails.title, companyName = state.jobDetails.companyName
            )
            Row() {
                Column {
                    Text(text = "Salary")
                    Text(text = "Type")
                    Text(text = "Location")
                }
                Column {
                    Text(text = state.jobDetails.salary)
                    Text(text = state.jobDetails.jobType)
                    Text(text = state.jobDetails.location)

                }
            }
            Column {
                Text(text = "Required")
                val lists = state.jobDetails.tags
                LazyColumn() {
                    items(lists.size) { index ->
                        lists[index]?.let { Text(text = it) }

                    }
                }


            }


        }
    }


}