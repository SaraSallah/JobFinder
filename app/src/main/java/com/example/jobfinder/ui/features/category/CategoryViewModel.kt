package com.example.jobfinder.ui.features.category

import com.example.domain.model.Category
import com.example.domain.model.JobDetails
import com.example.domain.usecase.GetAllCategoryUseCase
import com.example.domain.usecase.GetAllJobsFromCategory
import com.example.jobfinder.ui.base.BaseViewModel
import com.example.jobfinder.ui.features.search.toSearchForJobUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import org.xml.sax.ErrorHandler
import javax.inject.Inject

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

    fun getAllCategories() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllCategoryUseCase.invoke() },
            ::onGetAllCategorySuccess,
            ::onError
        )
    }

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

    private fun onGetAllJobsSuccess(jobs: List<JobDetails>) {
        _state.update {
            it.copy(
                isLoading = false,
                jobs = jobs.toSearchForJobUiState()
            )
        }
    }

    private fun onError(error: ErrorHandler) {
        _state.update {
            it.copy(isLoading = false, isError = true)

        }
    }

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