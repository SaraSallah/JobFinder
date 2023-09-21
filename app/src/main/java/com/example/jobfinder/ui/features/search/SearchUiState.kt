package com.example.jobfinder.ui.features.search

import com.example.domain.model.JobDetails
import com.example.jobfinder.ui.features.job_details.JobUiState

data class SearchUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val jobs: List<JobUiState> = emptyList(),
    val query: String = "",
)

fun List<JobDetails>.toSearchForJobUiState():List<JobUiState>{
    return map{
        JobUiState(
            jobId = it.jobId ,
            url = it.url ,
            title = it.title ,
            companyName = it.companyName ,
            companyLogo = it.companyLogo ,
            companyLogoUrl = it.companyLogoUrl ,
            category = it.category ,
            tags = it.tags ,
            jobType = it.jobType ,
            publishedDate = it.publishedDate ,
            salary = it.salary  ,
            description = it.description ,
            location = it.location
        )


    }

}