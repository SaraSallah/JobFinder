package com.example.jobfinder.ui.features.job_details

import com.example.domain.model.JobDetails

data class JobDetailsUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val jobDetails: JobUiState = JobUiState(),
)

data class JobUiState(
    val jobId: Int = 0,
    val url: String = "",
    val title: String = "",
    val companyName: String = "",
    val companyLogo: String = "",
    val companyLogoUrl: String = "",
    val category: String = "",
    val tags: List<String?> = emptyList(),
    val jobType: String = "",
    val publishedDate: String = "",
    val salary: String = " ",
    val description: String = "",
)

fun JobDetails.toJobUiState(): JobUiState {
    return JobUiState(
        jobId = jobId,
        url = url,
        title = title,
        companyName = companyName,
        companyLogo = companyLogo,
        companyLogoUrl = companyLogoUrl,
        category = category,
        tags = tags,
        jobType = jobType,
        publishedDate = publishedDate,
        salary = salary
    )
}
fun String.returnIfSalaryNotMentioned():String =
    "Salary not mentioned"
