package com.example.jobfinder.ui.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobfinder.ui.composables.CategoriesLazyRow
import com.example.jobfinder.ui.composables.ContentVisibility
import com.example.jobfinder.ui.composables.EventHandler
import com.example.jobfinder.ui.composables.HomeRow
import com.example.jobfinder.ui.composables.JobCardHome
import com.example.jobfinder.ui.composables.Loading
import com.example.jobfinder.ui.features.category.navigateToCategoryScreen
import com.example.jobfinder.ui.features.home.composable.HomeHeader
import com.example.jobfinder.ui.features.search.navigateToSearchScreen
import com.example.jobfinder.ui.theme.JobFinderTheme
import com.example.jobfinder.ui.theme.dimens

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    EventHandler(effects = viewModel.effect, handleEffect = { effect, navController ->
        when (effect) {
            HomeUiEffect.NavigateToSearchScreenEffect -> navController.navigateToSearchScreen()
            HomeUiEffect.NavigateToCategoryScreenEffect -> navController.navigateToCategoryScreen()

        }

    })

    HomeContent(
        state = state,
        listener = viewModel
    )

}

@Composable
fun HomeContent(
    state : HomeUiState ,
    listener: HomeInteractionListener
) {
    JobFinderTheme {
       Loading(state = state.isLoading || (state.jobs.isEmpty()
               && state.categories.isEmpty()))
        ContentVisibility(state = !state.isLoading && !state.isError
                && state.jobs.isNotEmpty()
                && state.categories.isNotEmpty()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                HomeHeader { listener.onClickSearchIcon() }
                HomeRow(text = "Recent jobs", onClick = {})
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(MaterialTheme.dimens.space16),
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space16)
                ) {
                    items(state.jobs.size) { index ->
                        val job = state.jobs[index]
                        JobCardHome(
                            imageUrl = job.companyLogo,
                            jobTitle = job.title,
                            companyName = job.companyName,
                            tags = job.tags,
                            location = job.location,
                            date = job.publishedDate
                        )
                    }
                }
                HomeRow(text = "Categories", onClick = listener::onCLickSeeALl)
                CategoriesLazyRow(state.categories){

                }


            }
            
        }
        



    }


}