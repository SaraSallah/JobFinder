package com.example.domain.usecase

import com.example.domain.model.Category
import com.example.domain.model.JobDetails
import com.example.domain.repository.JobFinderRepository
import javax.inject.Inject

class GetAllJobsFromCategory @Inject constructor(
    private val finderRepository: JobFinderRepository
) {
    suspend operator fun invoke(category: String): List<JobDetails>
    =finderRepository.getAllJobsFromCategory(category)
}