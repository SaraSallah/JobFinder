package com.example.data.repository

import com.example.data.source.mapper.toJobDetails
import com.example.data.source.network.JobFinderService
import com.example.domain.model.JobDetails
import com.example.domain.repository.JobFinderRepository
import javax.inject.Inject

class JobFinderRepositoryImp @Inject constructor(
    private val jobFinderService: JobFinderService,
) : JobFinderRepository {
    override suspend fun getAllJobs(): List<JobDetails> =
        jobFinderService.getListAllJobs().jobs!!.map { it!!.toJobDetails() }

    override suspend fun getLimitedJobList(limit: Int): List<JobDetails> =
        jobFinderService.getListJobs(limit).jobs!!.map { it!!.toJobDetails() }

    override suspend fun searchJobList(limit: Int, keyWord: String): List<JobDetails> =
        jobFinderService.searchJobList(limit, keyWord).jobs!!.map { it!!.toJobDetails() }


}