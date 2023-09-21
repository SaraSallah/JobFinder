package com.example.jobfinder.ui.features.job_details

import com.example.domain.model.JobDetails
import com.example.domain.usecase.GetJobDetailsUseCase
import com.example.jobfinder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import org.xml.sax.ErrorHandler
import javax.inject.Inject

@HiltViewModel
class JobDetailsViewModel @Inject constructor(
    private val getJobDetails: GetJobDetailsUseCase,
) : BaseViewModel<JobDetailsUiState, JobDetailsUiEffect>(JobDetailsUiState()) {
    override val TAG: String = this::class.simpleName.toString()
    private val jobId  :Int = 1773600
    init {
        getJobDetails()

    }
    fun getJobDetails(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            {getJobDetails.getJobDetails(jobId)},
            ::onGetJobDetailsSuccess,
            ::onGetJobDetailsError
        )
    }
    private fun onGetJobDetailsSuccess(jobDetails :JobDetails?){
        _state.update { it.copy(isLoading = false ,
            jobDetails =jobDetails!!.toJobUiState() ) }
        log(_state.value.jobDetails.toString())
    }
    private fun onGetJobDetailsError(error: ErrorHandler){
        _state.update{
            it.copy(isLoading = false , isError = true)

        }

    }

}