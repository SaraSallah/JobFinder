package com.example.jobfinder.ui.features.category

import com.example.domain.model.Category
import com.example.jobfinder.ui.features.job_details.JobUiState

data class CategoriesUiState (
    val isLoading : Boolean = false ,
    val isError : Boolean  = false,
    val categories : List<CategoryUiState> = emptyList() ,
    val jobs : List<JobUiState> = emptyList(),
    val selectedCategory : String ="" ,
)

data class CategoryUiState(
    val id: Int = 0,
    val name: String = "",
    val slug: String = "",
    val selectedCategory : Boolean =false ,

    )
fun List<Category>.toCategoriesUiState(): List<CategoryUiState> {
    return map {
        CategoryUiState(
            id = it.id,
            name = it.name,
            slug = it.slug,
            selectedCategory = false


        )
    }
}


