package com.example.jobfinder.ui.features.home

import com.example.domain.model.Category
import com.example.domain.model.JobDetails
import com.example.jobfinder.ui.features.category.CategoryUiState
import com.example.jobfinder.ui.features.job_details.JobUiState

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val jobs: List<JobUiState> = emptyList(),
    val categories: List<CategoryUiState> = emptyList(),
)

//data class CategoryUiState(
//    val id: Int = 0,
//    val name: String = "",
//    val slug: String = "",
//)

fun List<Category>.toCategoryUiState(): List<CategoryUiState> {
    return map {
        CategoryUiState(
            id = it.id,
            name = it.name,
            slug = it.slug
        )
    }
}

fun List<JobDetails>.toJobWithSalaryUiState(): List<JobUiState> {
    return map {
        JobUiState(
            jobId = it.jobId,
            url = it.url,
            title = it.title,
            companyName = it.companyName,
            companyLogo = it.companyLogo,
            companyLogoUrl = it.companyLogoUrl,
            category = it.category,
            tags = it.tags,
            jobType = it.jobType,
            publishedDate = it.publishedDate,
            salary = it.salary,
            description = it.description,
            location = it.location
        )


    }

}