package com.example.jobfinder.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
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
import com.example.jobfinder.ui.theme.Shapes
import com.example.jobfinder.ui.theme.black37
import com.example.jobfinder.ui.theme.black60
import com.example.jobfinder.ui.theme.dimens

@Composable
fun JobCards(
    modifier: Modifier,
    imageUrl: String,
    jobTitle: String,
    companyName: String,
    tags: List<String?>,
    location: String,
    date: String,
) {
    Card(
        modifier = modifier

            .fillMaxWidth()
            .height(190.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(
                    vertical = MaterialTheme.dimens.space8,
                    horizontal = MaterialTheme.dimens.space16
                )
        ) {
            ImageNetwork(
                imageUrl = imageUrl,
                contentDescription = stringResource(R.string.company_logo),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .weight(.2f)
                    .clip(Shapes.extraLarge),
                contentScale = ContentScale.Crop,

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
                Text(
                    text = companyName,
                    style = MaterialTheme.typography.bodySmall,
                    color = black60,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Divider(
                    color = black60,
                    thickness = .5.dp,
                    modifier = Modifier.padding(
                        top = MaterialTheme.dimens.space8
                    )
                )
            }


        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.dimens.space16,
                    vertical = MaterialTheme.dimens.space8
                ),
            contentPadding = PaddingValues(end = MaterialTheme.dimens.space16),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space8)
        ) {
            items(tags.size) { index ->
                val tag = tags[index]
                tag?.let { CustomChip(text = it) }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.dimens.space16, vertical = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = location,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = date,
                style = MaterialTheme.typography.bodySmall,
                color = black37,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}

@Composable
fun SmallJobCard(

) {

}


@Preview
@Composable
fun JobCardPreview() {
    JobCards(
        modifier = Modifier,
        imageUrl = "https://picsum.photos/200/300",
        jobTitle = "Ui/Ux Designer",
        companyName = "AirBnB",
        tags = listOf("Ui", "Ux", "Designer"),
        location = "Egypt",
        date = "22/2/22"
    )

}