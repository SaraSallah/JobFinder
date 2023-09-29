package com.example.jobfinder.ui.features.search.composble

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfinder.R
import com.example.jobfinder.ui.composables.ImageNetwork
import com.example.jobfinder.ui.theme.black60
import com.example.jobfinder.ui.theme.dimens

@Composable
fun JobCard(
    imageUrl: String,
    jobTitle: String,
    companyName: String,
    jobType  :String ,
    onCLick :() ->Unit

    ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .clickable { onCLick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(
                    vertical = MaterialTheme.dimens.space8,
                    horizontal = MaterialTheme.dimens.space16
                )
        ) {
            ImageNetwork(
                imageUrl = imageUrl,
                contentDescription = stringResource(R.string.company_logo),
                modifier = Modifier
                    .fillMaxSize()
                    .weight(.2f)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop ,


            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.7f)
                    .padding(
                        MaterialTheme.dimens.space8
                    ),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = jobTitle,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis

                )
                Row(modifier = Modifier.fillMaxWidth() ,
                    horizontalArrangement = Arrangement.SpaceAround){
                Text(
                    text = companyName,
                    style = MaterialTheme.typography.bodySmall,
                    color = black60,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                    Text(
                        text = jobType,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

            }}

        }




    }
}

@Preview
@Composable
fun PreviewJobCard() {
    JobCard(
        imageUrl ="https://picsum.photos/200/300",
        jobTitle = "Ui/Ux Designer",
        companyName = "AirBnB" ,
        jobType ="Egypt" ,
    ){}
}



