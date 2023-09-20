package com.example.jobfinder.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CompanyCard(
    imageUrl: String,
    jobTitle: String,
    companyName: String,
) {
    Card(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .height(124.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
        )

    ) {Row(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 8.dp , vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        ImageNetwork(
            imageUrl = imageUrl
        )
        Column {
            Text(text = jobTitle)
            Text(text = companyName)
        }}
    }

}

@Preview
@Composable
fun PreviewCompanyCard() {
    CompanyCard(
    imageUrl = "https://i.pinimg.com/originals/0a/0b/9a/0a0b9a4b5b5b3b0b5b5b5b5b5b5b5b5b.jpg",
        jobTitle = "Ui/Ux Designer",
        companyName = "AirBnB"
    )

}