package com.example.jobfinder.ui.features.home

import com.example.domain.model.Category
import com.example.jobfinder.R
import com.example.jobfinder.ui.features.job_details.JobUiState

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val jobs: List<JobUiState> = emptyList(),
    val categories: List<CategoryUiState> = emptyList(),
    val  salariesJob : List<JobUiState> = emptyList() ,
    val categoriesJob : List <JobUiState> = emptyList(),
)

data class CategoryUiState(
    val id: Int = 0,
    val name: String = "",
    val slug: String = "",
    val categoryIcon : Int =0,
)

val categoryIcon :Map<Int ,Int > = mapOf(
    1 to R.drawable.software,
    2 to R.drawable.customer ,
    3 to R.drawable.design ,
    4 to R.drawable.markt ,
    5 to R.drawable.sales ,
    6 to R.drawable.product ,
    7 to R.drawable.bus,
    8 to R.drawable.data ,
    9 to R.drawable.dev ,
    10 to R.drawable.finance ,
    11 to R.drawable.hr ,
    12 to R.drawable.qa,
    13 to R.drawable.writing ,
    14 to R.drawable.markting


)
fun List<Category>.toCategoryHomeUiState(): List<CategoryUiState> {
    val categoryIconKeys = categoryIcon.keys.toList() // Get the list of keys (1, 2, 3, ...)

    return mapIndexed { index, category ->
        val categoryIconKey = categoryIconKeys.getOrNull(index % categoryIconKeys.size)
        CategoryUiState(
            id = category.id,
            name = category.name,
            slug = category.slug,
            categoryIcon = categoryIcon[categoryIconKey] ?: 0 // Get the icon based on the key
        )
    }
}


