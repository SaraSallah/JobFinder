package com.example.jobfinder.ui.features.home

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.model.Category
import com.example.domain.model.JobDetails
import com.example.domain.usecase.GetAllCategoryUseCase
import com.example.domain.usecase.GetJobListUseCase
import com.example.jobfinder.ui.base.BaseViewModel
import com.example.jobfinder.ui.features.search.toSearchForJobUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllJobs() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllJobsUseCase.getAllJobs() },
            ::onGetAllJobsSuccess,
            ::onError
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
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
                categories = categories.take(6).toCategoryHomeUiState()
            )
        }
        log(_state.value.categories.toString())

    }

    private fun onError(error: Throwable) {
        _state.update {
            it.copy(isLoading = false, isError = true)

        }
    }

    override fun onClickSearchIcon() {
        effectActionExecutor(_effect, HomeUiEffect.NavigateToSearchScreenEffect)
    }
   override fun onCLickSeeALlCategory(){
       effectActionExecutor(_effect,HomeUiEffect.NavigateToCategoryScreenEffect)

   }

    override fun onClickJob(jobId: Int) {
        effectActionExecutor(_effect, HomeUiEffect.NavigateToJobDetailsScreen(jobId))

    }
}
