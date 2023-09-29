package com.example.jobfinder.ui.features.job_details

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jobfinder.ui.navigation.Screen

private val ROUTE = Screen.JobDetailsScreen.route

fun NavController.navigateToJobDetailsScreen(jobId: Int) {
    navigate("$ROUTE/$jobId")
}

fun NavGraphBuilder.jobDetailsRoute() {
    composable(
        route = "$ROUTE/{${JobDetailsArgs.JOB_ID}}",
        arguments = listOf(
            navArgument(name = JobDetailsArgs.JOB_ID) {
                NavType.IntType
            }
        )
    ) {
        JobDetailsScreen()
    }
}

class JobDetailsArgs(savedStateHandle: SavedStateHandle) {
    val jobID: String = checkNotNull(savedStateHandle[JOB_ID])

    companion object {
        const val JOB_ID = "jobId"
    }

}

