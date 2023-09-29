package com.example.jobfinder.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jobfinder.ui.features.home.HomeInteractionListener
import com.example.jobfinder.ui.features.job_details.JobDetailsUiState
import com.example.jobfinder.ui.features.job_details.JobUiState
import com.example.jobfinder.ui.features.search.composble.JobCard
import com.example.jobfinder.ui.theme.dimens

@Composable
fun JobLazyRow(
    jobs: List<JobUiState>,
    listener: HomeInteractionListener,
) {
    LazyRow(
        Modifier
            .fillMaxWidth(), contentPadding = PaddingValues(MaterialTheme.dimens.space16),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space16)
    ) {
        items(jobs.size) { index ->
            val job = jobs[index]
            JobCards(
                modifier = Modifier
                    .width(250.dp)
                    .height(190.dp),
                id = job.jobId,
                imageUrl = job.companyLogo,
                jobTitle = job.title,
                companyName = job.companyName,
                tags = job.tags,
                location = job.location,
                date = job.publishedDate,
                onClick = { listener.onClickJob(job.jobId) },
            )
        }
    }
}

@Composable
fun JobLazyColumn(
    jobs : List<JobUiState> ,
    listener: HomeInteractionListener
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(MaterialTheme.dimens.space16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space16)
    ) {
        items(jobs.size) { index ->
            val job = jobs[index]
            JobCard(
                imageUrl = job.companyLogo,
                jobTitle = job.title,
                companyName = job.companyName,
                jobType = job.category ,
                onCLick = { listener.onClickJob(job.jobId)}
//
            )
        }

    }
}
