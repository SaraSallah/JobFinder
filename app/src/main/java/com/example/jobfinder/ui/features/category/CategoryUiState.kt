package com.example.jobfinder.ui.features.category

import com.example.jobfinder.ui.features.home.CategoryUiState
import com.example.jobfinder.ui.features.job_details.JobUiState

data class CategoriesUiState (
    val isLoading : Boolean = false ,
    val isError : Boolean  = false,
    val categories : List<CategoryUiState> = emptyList() ,
    val jobs : List<JobUiState> = emptyList(),
)
