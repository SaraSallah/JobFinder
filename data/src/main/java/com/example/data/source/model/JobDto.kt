package com.example.data.source.model


import com.google.gson.annotations.SerializedName

data class JobDto(
    @SerializedName("candidate_required_location")
    val candidateRequiredLocation: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("company_logo")
    val companyLogo: String? = null,
    @SerializedName("company_logo_url")
    val companyLogoUrl: String? = null,
    @SerializedName("company_name")
    val companyName: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("job_type")
    val jobType: String? = null,
    @SerializedName("publication_date")
    val publicationDate: String? = null,
    @SerializedName("salary")
    val salary: String? = null,
    @SerializedName("tags")
    val tags: List<String?>? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null
)