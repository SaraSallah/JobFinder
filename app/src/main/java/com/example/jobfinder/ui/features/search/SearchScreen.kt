package com.example.jobfinder.ui.features.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobfinder.R
import com.example.jobfinder.ui.composables.ContentVisibility
import com.example.jobfinder.ui.composables.EventHandler
import com.example.jobfinder.ui.composables.JobCards
import com.example.jobfinder.ui.composables.Loading
import com.example.jobfinder.ui.composables.SearchPlaceHolder
import com.example.jobfinder.ui.features.job_details.navigateToJobDetailsScreen
import com.example.jobfinder.ui.features.search.composble.JobCard
import com.example.jobfinder.ui.features.search.composble.SearchTextField
import com.example.jobfinder.ui.theme.dimens

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    EventHandler(effects = viewModel.effect, handleEffect = { effect, navController ->
        when (effect) {
            is SearchUiEffect.NavigateToJobDetailsScreen
            -> navController.navigateToJobDetailsScreen(effect.jobId)

        }        })
    SearchContent(
        state = state,
        listener = viewModel
    )


}

@Composable
fun SearchContent(
    state: SearchUiState,
    listener: SearchInteractionListener,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            SearchTextField(
                query = state.query,
                onValueChange = listener::onSearchTextChange,
                iconPainter = painterResource(id = R.drawable.icon_search)
            )
        }
        Loading(state = state.isLoading)

        ContentVisibility(state = state.jobs.isNotEmpty() && !state.isLoading) {
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
                        id = job.jobId ,
                        imageUrl = job.companyLogo,
                        jobTitle = job.title,
                        companyName =job.companyName ,
                        tags = job.tags,
                        location = job.location,
                        date = job.publishedDate,
                        onClick = { listener.onClickJobJob(job.jobId) }
                    )
                }
            }
        }

       SearchPlaceHolder(state = state.query.isBlank())

    }


}