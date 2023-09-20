package com.example.jobfinder.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfinder.ui.theme.Shapes
import com.example.jobfinder.ui.theme.dimens

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
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary
        ),
        shape = MaterialTheme.shapes.medium


    ) {
        Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ){
        ImageNetwork(
            imageUrl = imageUrl,
            contentDescription = "Company Logo",

            modifier = Modifier
                .size(120.dp)
                .clip(Shapes.medium),
            contentScale = ContentScale.Crop

        )
        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(
                    vertical = MaterialTheme.dimens.space16,
                    horizontal = MaterialTheme.dimens.space8
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = jobTitle,
                style = MaterialTheme.typography.bodyLarge.copy(
                    MaterialTheme.colorScheme.onSecondary
                )
            )
            Text(
                text = companyName,
                style = MaterialTheme.typography.bodySmall.
                        copy(
                    MaterialTheme.colorScheme.onSecondary
                )            )

        }}
    }

}

@Preview(widthDp = 320)
@Composable
fun PreviewCompanyCard() {
    CompanyCard(
    imageUrl ="https://picsum.photos/200/300",
        jobTitle = "Ui/Ux Designer",
        companyName = "AirBnB"
    )

}