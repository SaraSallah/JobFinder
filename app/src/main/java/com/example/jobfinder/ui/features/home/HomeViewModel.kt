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
        getAllJobs()
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
        val updatedJobs = jobs.toSearchForJobUiState()
        val jobCategory = updatedJobs.filter { it.category =="Software Development" }
        _state.update { uiState ->
            uiState.copy(
                jobs = updatedJobs,
                salariesJob = jobCategory,
                isLoading = false,


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
                categories = categories.toCategoryHomeUiState()
            )
        }
        log(_state.value.categories.toString())

    }

    private fun onError(error: ErrorHandler) {
        _state.update {
            it.copy(isLoading = false, isError = true)

        }
    }
    override fun onClickSearchIcon(){
        effectActionExecutor(_effect ,HomeUiEffect.NavigateToSearchScreenEffect)
    }
   override fun onCLickSeeALl(){
       effectActionExecutor(_effect,HomeUiEffect.NavigateToCategoryScreenEffect)

   }

}
