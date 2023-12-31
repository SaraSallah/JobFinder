package com.example.data.source.network

import com.example.data.source.model.JobsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface JobFinderService {
    @GET("remote-jobs")
    suspend fun getListJobs(@Query("limit") limit: Int): JobsDto
    @GET("remote-jobs")
    suspend fun getListAllJobs(): JobsDto

    @GET("remote-jobs")
    suspend fun searchJobList(
        @Query("limit") limit: Int,
        @Query("search") keyword: String?,
    ): JobsDto


}