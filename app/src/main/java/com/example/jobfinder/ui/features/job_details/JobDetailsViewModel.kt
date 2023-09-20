package com.example.jobfinder.ui.features.job_details

import com.example.domain.model.JobDetails
import com.example.domain.usecase.GetJobDetailsUseCase
import com.example.jobfinder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class JobDetailsViewModel @Inject constructor(
    private val getJobDetails: GetJobDetailsUseCase,
) : BaseViewModel<JobDetailsUiState, JobDetailsUiEffect>(JobDetailsUiState()) {
    override val TAG: String = this::class.simpleName.toString()
    private val jobId  :Int = 1788491
    init {
        getJobDetails()

    }
    fun getJobDetails(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            {getJobDetails.getJobDetails(jobId)},
            ::onGetJobDetailsSuccess,
            {}
        )
        log(_state.value.jobDetails.toString())
        val runBlock = runBlocking{
            getJobDetails.getJobDetails(jobId).toString()
        }

    }
    private fun onGetJobDetailsSuccess(jobDetails :JobDetails?){
        _state.update { it.copy(isLoading = false ,
            jobDetails =jobDetails!!.toJobUiState() ) }
        log(_state.value.jobDetails.toString())
    }

}