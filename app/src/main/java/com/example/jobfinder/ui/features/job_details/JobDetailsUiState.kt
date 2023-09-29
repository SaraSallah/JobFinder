package com.example.jobfinder.ui.features.job_details

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.model.JobDetails
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.TimeZone

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


@SuppressLint("SimpleDateFormat")
fun String.formatPublishedDate(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val publishedDate = dateFormat.parse(this)
    val now = Date()

    val durationMillis = now.time - publishedDate!!.time
    val secondsAgo = durationMillis / 1000
    val minutesAgo = secondsAgo / 60
    val hoursAgo = minutesAgo / 60
    val daysAgo = hoursAgo / 24

    return when {
        daysAgo < 1 -> {
            when {
                hoursAgo < 1 -> "Just now"
                hoursAgo == 1L -> "1 hour ago"
                else -> "$hoursAgo hours ago"
            }
        }
        daysAgo == 1L -> "Yesterday"
        else -> {
            val dateFormatOutput = SimpleDateFormat("MMM d, yyyy")
            dateFormatOutput.format(publishedDate)
        }
    }
}



fun String.toJobType(): String {
    return when (this.toLowerCase(Locale.ROOT)) {
        "full_time" -> "Full Time"
        "par_time" -> "Part Time"
        else -> this // Return the original value for any other cases
    }
}