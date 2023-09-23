package com.example.jobfinder.ui.features.home

import com.example.domain.model.Category
import com.example.domain.model.JobDetails
import com.example.domain.usecase.GetAllCategoryUseCase
import com.example.domain.usecase.GetJobListUseCase
import com.example.jobfinder.ui.base.BaseViewModel
import com.example.jobfinder.ui.features.search.toSearchForJobUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import org.xml.sax.ErrorHandler
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllJobsUseCase: GetJobListUseCase,
    private val getAllCategoryUseCase: GetAllCategoryUseCase,
) :
    BaseViewModel<HomeUiState, HomeUiEffect>(HomeUiState()), HomeInteractionListener {
    override val TAG: String = this::class.simpleName.toString()

    init {
//        getAllJobs()
        getAllCategory()
    }

    fun getAllJobs() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllJobsUseCase.getAllJobs() },
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

    fun getAllCategory() {
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
