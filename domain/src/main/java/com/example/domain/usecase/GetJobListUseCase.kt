package com.example.domain.usecase

import com.example.domain.model.JobDetails
import com.example.domain.repository.JobFinderRepository
import javax.inject.Inject

class GetJobListUseCase @Inject constructor(
    private val jobFinderRepository: JobFinderRepository
){
    suspend fun getAllJobs(): List<JobDetails> =
        jobFinderRepository.getAllJobs()

    suspend fun getLimitedJobList(limit : Int):List<JobDetails> =
        jobFinderRepository.getLimitedJobList(limit)
}