package com.example.data.repository

import com.example.data.source.mapper.toCategory
import com.example.data.source.mapper.toJobDetails
import com.example.data.source.network.JobFinderService
import com.example.data.utils.Results
import com.example.domain.model.Category
import com.example.domain.model.JobDetails
import com.example.domain.repository.JobFinderRepository
import javax.inject.Inject

class JobFinderRepositoryImp @Inject constructor(
    private val jobFinderService: JobFinderService,
) : JobFinderRepository {
    override suspend fun getAllJobs(): List<JobDetails> =
        wrap { jobFinderService.getListAllJobs().jobs!!.map { it!!.toJobDetails() } }.toData()
            ?: emptyList()

    override suspend fun getLimitedJobList(limit: Int): List<JobDetails> =
        wrap { jobFinderService.getListJobs(limit).jobs!!.map { it!!.toJobDetails() } }.toData()
            ?: emptyList()

    override suspend fun searchJobList(limit: Int?, keyWord: String): List<JobDetails> =
        wrap {
//            limit?.let {
                jobFinderService.searchJobList( keyWord).jobs
//        }!!
                ?.map { it!!.toJobDetails() }
        }.toData() ?: emptyList()
    override suspend fun getAllCategory() :List<Category> =
        wrap {
            jobFinderService.getAllCategory().category!!.map { it!!.toCategory() }
        }.toData() ?: emptyList()
}


inline fun <T> wrap(block: () -> T): Results<T> {
    return try {
        val result = block()
        Results.Success(result)
    } catch (e: Exception) {
        val errorMessage = e.message ?: "An unknown error occurred"
        Results.Error(errorMessage)
    }
}


