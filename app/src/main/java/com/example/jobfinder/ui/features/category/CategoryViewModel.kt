package com.example.jobfinder.ui.features.category

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.model.Category
import com.example.domain.model.JobDetails
import com.example.domain.usecase.GetAllCategoryUseCase
import com.example.domain.usecase.GetAllJobsFromCategory
import com.example.jobfinder.ui.base.BaseViewModel
import com.example.jobfinder.ui.features.search.toSearchForJobUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getAllCategoryUseCase: GetAllCategoryUseCase,
    private val getAllJobsFromCategory: GetAllJobsFromCategory,
) : BaseViewModel<CategoriesUiState, CategoriesUiState>(CategoriesUiState()),
    CategoryInteractionListener {

    override val TAG: String = this::class.simpleName.toString()

    init {

        getAllCategories()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllCategories() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllCategoryUseCase.invoke() },
            this::onGetAllCategorySuccess,
            ::onError
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onGetAllCategorySuccess(categories: List<Category>) {
        val updateCategories = categories.toCategoriesUiState()
        val updatedCategory = updateSelectedCategory(updateCategories
            , updateCategories.first().id)
        _state.update {
            it.copy(
                isLoading = false,
                categories = updatedCategory,
                selectedCategory = categories.first().name
            )
        }


        getAllJobsFromCategory(_state.value.selectedCategory)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getAllJobsFromCategory(category: String) {
        _state.update {
            it.copy(
                isLoading = true,
            )
        }
        tryToExecute(
            {
                getAllJobsFromCategory.invoke(category)
            },
            ::onGetAllJobsSuccess,
            ::onError
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onGetAllJobsSuccess(jobs: List<JobDetails>) {
        _state.update {
            it.copy(
                isLoading = false,
                jobs = jobs.toSearchForJobUiState()
            )
        }
    }

    private fun onError(error: Throwable) {
        _state.update {
            it.copy(isLoading = false, isError = true)

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClickCategory(categoryId: Int) {
        val updatedCategory = updateSelectedCategory(_state.value.categories, categoryId)
        _state.update {
            it.copy(
                categories = updatedCategory,
                selectedCategory = it.categories.find { it.id ==categoryId }!!.name,

                )
        }
        getAllJobsFromCategory(_state.value.selectedCategory)
    }

    private fun updateSelectedCategory(
        categories: List<CategoryUiState>,
        selectedCategoryId: Int,
    ): List<CategoryUiState> {
        return categories.map { category ->
            category.copy(selectedCategory = category.id == selectedCategoryId)
        }
    }


}