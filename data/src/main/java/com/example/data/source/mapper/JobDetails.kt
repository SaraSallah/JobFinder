package com.example.data.source.mapper

import com.example.data.source.model.JobDto
import com.example.domain.model.JobDetails

fun JobDto.toJobDetails() = JobDetails(
    jobId = id ?: 0,
    url = url ?: "",
    title = title ?: "",
    companyName = companyName ?: "",
    companyLogo = companyLogo ?: "",
    companyLogoUrl = companyLogoUrl ?: "",
    category = category ?: "",
    tags = tags ?: emptyList(),
    salary = salary ?: "",
    publishedDate = publicationDate ?: "",
    jobType = jobType ?: "",
    description = description ?: "",
    )