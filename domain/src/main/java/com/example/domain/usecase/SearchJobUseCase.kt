package com.example.domain.usecase

import com.example.domain.model.JobDetails
import com.example.domain.repository.JobFinderRepository
import javax.inject.Inject

class SearchJobUseCase @Inject constructor(
    private val jobFinderRepository: JobFinderRepository
){
    suspend operator fun invoke(query : String,limit :Int =15) :List<JobDetails> =
        jobFinderRepository.searchJobList(keyWord =query , limit =limit)
}