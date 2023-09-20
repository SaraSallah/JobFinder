package com.example.domain.model

data class JobDetails(
    val jobId: Int,
    val url: String,
    val title:String,
    val companyName: String,
    val companyLogo: String,
    val companyLogoUrl: String,
    val category: String,
    val tags: List<String?>,
    val jobType: String,
    val publishedDate: String,
    val salary:String,
    val description: String,
    val location :String
)
