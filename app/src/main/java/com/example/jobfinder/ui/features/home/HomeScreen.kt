package com.example.jobfinder.ui.features.home

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobfinder.ui.composables.CategoriesLazyRowDesign
import com.example.jobfinder.ui.composables.ContentVisibility
import com.example.jobfinder.ui.composables.ErrorPlaceHolder
import com.example.jobfinder.ui.composables.EventHandler
import com.example.jobfinder.ui.composables.HomeRow
import com.example.jobfinder.ui.composables.JobLazyColumn
import com.example.jobfinder.ui.composables.JobLazyRow
import com.example.jobfinder.ui.composables.Loading
import com.example.jobfinder.ui.features.category.navigateToCategoryScreen
import com.example.jobfinder.ui.features.home.composable.HomeHeader
import com.example.jobfinder.ui.features.job_details.navigateToJobDetailsScreen
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
             is HomeUiEffect.NavigateToJobDetailsScreen ->
                 navController.navigateToJobDetailsScreen(effect.jobId)

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
        Loading(
            state = state.isLoading || (state.jobs.isEmpty()
                    && state.categories.isEmpty())
        )
        ErrorPlaceHolder(state = state.isError)
        ContentVisibility(
            state = !state.isLoading && !state.isError
                    && state.jobs.isNotEmpty()
                    && state.categories.isNotEmpty()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space8),
                ) {
                HomeHeader { listener.onClickSearchIcon() }
                HomeRow(text = "Recent jobs", onClick = {})

                JobLazyRow(jobs = state.jobs, listener = listener)


                HomeRow(text = "Categories", onClick = listener::onCLickSeeALlCategory)


                CategoriesLazyRowDesign(state.categories)

                JobLazyColumn(jobs = state.jobs, listener = listener)

            }




    }


}
}