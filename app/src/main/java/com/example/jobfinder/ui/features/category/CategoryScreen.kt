package com.example.jobfinder.ui.features.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobfinder.ui.composables.CategoriesLazyRow
import com.example.jobfinder.ui.composables.ContentVisibility
import com.example.jobfinder.ui.composables.JobCards
import com.example.jobfinder.ui.composables.Loading
import com.example.jobfinder.ui.theme.JobFinderTheme
import com.example.jobfinder.ui.theme.dimens

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    CategoryContent(
        state = state,
        listener = viewModel
    )


}

@Composable
fun CategoryContent(
    state: CategoriesUiState,
    listener: CategoryInteractionListener,
) {
    JobFinderTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Loading(state = state.isLoading && state.categories.isEmpty())
            CategoriesLazyRow(state.categories, onClick = listener::onClickCategory)
            Column {
                Loading(state = state.isLoading )
                ContentVisibility(state = state.jobs.isNotEmpty()
                        && !state.isLoading && !state.isError) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        contentPadding = PaddingValues(MaterialTheme.dimens.space16),
                        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space16)
                    ) {
                        items(state.jobs.size) { index ->
                            val job = state.jobs[index]

                            JobCards(
                                modifier = Modifier,
                                id =job.jobId ,
                                imageUrl = job.companyLogo,
                                jobTitle = job.title,
                                companyName = job.companyName,
                                tags = job.tags,
                                location = job.location,
                                date = job.publishedDate,{}
                            )
                        }
                    }
                }

            }
        }
        }
    }

