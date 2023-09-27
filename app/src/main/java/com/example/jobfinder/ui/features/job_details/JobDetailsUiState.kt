package com.example.jobfinder.ui.features.job_details

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.model.JobDetails
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class JobDetailsUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val jobDetails: JobUiState = JobUiState(),
)

data class JobUiState(
    val jobId: Int = 0,
    val url: String = "",
    val title: String = "",
    val companyName: String = "",
    val companyLogo: String = "",
    val companyLogoUrl: String = "",
    val category: String = "",
    val tags: List<String?> = emptyList(),
    val jobType: String = "",
    val publishedDate: String = "",
    val salary: String = " ",
    val description: String = "",
    val location: String = "",
)

@RequiresApi(Build.VERSION_CODES.O)
fun JobDetails.toJobUiState(): JobUiState {
    return JobUiState(
        jobId = jobId,
        url = url,
        title = title,
        companyName = companyName,
        companyLogo = companyLogo,
        companyLogoUrl = companyLogoUrl,
        category = category,
        tags = tags,
        jobType = jobType.toJobType(),
        publishedDate = publishedDate.formatPublishedDate(),
        salary = salary.returnIfSalaryNotMentioned(salary),
        description = description.extractRealWords(),
        location = location
    )
}

fun String.returnIfSalaryNotMentioned(salary: String): String =
    if (salary.isBlank()) "Salary not mentioned"
    else salary

fun String.extractRealWords(): String {
    // Use a regular expression to remove HTML tags and keep only text
    return this.replace(Regex("<[^>]+>"), "")
}

@RequiresApi(Build.VERSION_CODES.O)
fun String.formatPublishedDate(): String {
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val publishedDateTime = LocalDateTime.parse(this, dateFormatter)
    val now = LocalDateTime.now()
    val duration = Duration.between(publishedDateTime, now)

    val daysAgo = duration.toDays()
    val hoursAgo = duration.toHours()

    return when {
        daysAgo < 1 -> {
            when {
                hoursAgo < 1 -> "Just now"
                hoursAgo == 1L -> "1 hour ago"
                else -> "$hoursAgo hours ago"
            }
        }

        daysAgo == 1L -> "Yesterday"
        else -> "$daysAgo days ago"
    }
}

fun String.toJobType(): String {
    return when (this.toLowerCase()) {
        "full_time" -> "Full Time"
        "par_time" -> "Part Time"
        else -> this // Return the original value for any other cases
    }
}