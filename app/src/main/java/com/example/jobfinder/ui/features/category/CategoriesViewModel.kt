package com.example.jobfinder.ui.features.category

import com.example.domain.model.Category
import com.example.domain.usecase.GetAllCategoryUseCase
import com.example.jobfinder.ui.base.BaseViewModel
import com.example.jobfinder.ui.features.home.toCategoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import org.xml.sax.ErrorHandler
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getAllCategoryUseCase: GetAllCategoryUseCase,
) : BaseViewModel<CategoriesUiState, CategoriesUiState>(CategoriesUiState()),
    CategoriesInteractionListener {

    override val TAG: String =this ::class.simpleName.toString()
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
        _state.update {
            it.copy(
                isLoading = false,
                categories = categories.toCategoryUiState()
            )
        }
        log(_state.value.categories.toString())

    }

    private fun onError(error: ErrorHandler) {
        _state.update {
            it.copy(isLoading = false, isError = true)

        }
    }
 }