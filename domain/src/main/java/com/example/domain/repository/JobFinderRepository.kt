package com.example.domain.repository

import com.example.domain.model.Category
import com.example.domain.model.JobDetails

interface JobFinderRepository {
    suspend fun getAllJobs(): List<JobDetails>
    suspend fun getLimitedJobList(limit: Int): List<JobDetails>
    suspend fun searchJobList(limit: Int?, keyWord: String): List<JobDetails>
    suspend fun getAllCategory(): List<Category>
    suspend fun getAllJobsFromCategory(category: String): List<JobDetails>
}