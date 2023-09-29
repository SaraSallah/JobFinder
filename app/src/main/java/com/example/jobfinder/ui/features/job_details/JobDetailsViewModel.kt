package com.example.jobfinder.ui.features.job_details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.SavedStateHandle
import com.example.domain.model.JobDetails
import com.example.domain.usecase.GetJobDetailsUseCase
import com.example.jobfinder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class JobDetailsViewModel @Inject constructor(
    private val getJobDetails: GetJobDetailsUseCase,
    savedStateHandle: SavedStateHandle,

    ) : BaseViewModel<JobDetailsUiState, JobDetailsUiEffect>(JobDetailsUiState()) {
    override val TAG: String = this::class.simpleName.toString()
    private val args =JobDetailsArgs(savedStateHandle)

    init {
        getJobDetails()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getJobDetails(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            {getJobDetails.getJobDetails(args.jobID.toInt())},
            ::onGetJobDetailsSuccess,
            ::onGetJobDetailsError
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onGetJobDetailsSuccess(jobDetails: JobDetails?) {
        _state.update {
            it.copy(
                isLoading = false,
                jobDetails = jobDetails!!.toJobUiState()
            )
        }
        log(_state.value.jobDetails.toString())
    }

    private fun onGetJobDetailsError(error: Throwable) {
        _state.update {
            it.copy(isLoading = false, isError = true)

        }

    }

}