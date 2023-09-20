package com.example.jobfinder.ui.features.job_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.tooling.preview.Preview
import com.example.jobfinder.ui.composables.ImageNetwork

@Composable
fun JobDetailsScreen(
    viewModel: JobDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()


}

@Preview(showSystemUi = true)
@Composable
fun JobDetailsContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            ImageNetwork(
                imageUrl =
                "https://rubygarage.org/resources/guide-on-cooperation-flow-with-rubygarage"
            )
            Column {
                Text(text = "Ui/Ux Designer")
                Text(text = "AirBnB")
            }
        }
        Row() {
            Column {
                Text(text = "Salary")
                Text(text = "Type")
                Text(text = "Location")
            }
            Column {
                Text(text = "Not mentioned")
                Text(text = "Full Time")
                Text(text = "Cairo,Egypt")

            }
        }
        Column {
            Text(text = "Required")
            val lists = listOf("Designer", "Ui", " Ux")
            LazyColumn() {
                items(lists.size) { index ->
                    Text(text = lists[index])

                }
            }


        }


    }


}