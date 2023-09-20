package com.example.data.source.model


import com.google.gson.annotations.SerializedName

data class JobsDto(
    @SerializedName("job-count")
    val jobCount: Int? = null,
    @SerializedName("jobs")
    val jobs: List<JobDto?>? = null,
    @SerializedName("0-legal-notice")
    val legalNotice: String? = null,
    @SerializedName("00-warning")
    val warning: String? = null
)