package com.example.jobfinder.ui.features.category

interface CategoryInteractionListener {
    fun getAllJobsFromCategory(category: String)
    fun onClickCategory(categoryId: Int)
}