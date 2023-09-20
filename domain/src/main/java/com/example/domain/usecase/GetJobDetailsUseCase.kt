package com.example.domain.usecase

import com.example.domain.model.JobDetails
import com.example.domain.repository.JobFinderRepository
import javax.inject.Inject

class GetJobDetailsUseCase @Inject constructor(
    private val jobFinderRepository: JobFinderRepository,
) {
    suspend fun getJobDetails(jobId: Int): JobDetails? =
        jobFinderRepository.getAllJobs().firstOrNull { it.jobId == jobId }
}