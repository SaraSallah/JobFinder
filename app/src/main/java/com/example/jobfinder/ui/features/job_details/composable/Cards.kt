package com.example.jobfinder.ui.features.job_details.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jobfinder.R
import com.example.jobfinder.ui.composables.ImageNetwork
import com.example.jobfinder.ui.theme.Shapes
import com.example.jobfinder.ui.theme.black60
import com.example.jobfinder.ui.theme.black87
import com.example.jobfinder.ui.theme.dimens

@Composable
fun ChipJobDetails(
    cardName : String,
    cardValue : String ,
    cardIcon :Int,
    ) {
    Column ( horizontalAlignment = Alignment.CenterHorizontally){
        Card( modifier = Modifier
            .width(MaterialTheme.dimens.space100)
            .height(MaterialTheme.dimens.space112),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onTertiary),
            border = BorderStroke(width = 1.dp, color =MaterialTheme.colorScheme.onErrorContainer),
            shape = Shapes.large,

        ) {
            Column(
                modifier = Modifier.
                fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier
                        .size(MaterialTheme.dimens.space24),
                    painter = painterResource(id = cardIcon),
                    contentDescription = stringResource(id = R.string.search),
                    tint = MaterialTheme.colorScheme.primary,
                    )
                Text(
                    text = cardName,
                    style = MaterialTheme.typography.bodyMedium,
                    color = black87,
                    maxLines = 1,
                    overflow = TextOverflow.Visible

                )
                Text(
                    text = cardValue,
                    style = MaterialTheme.typography.bodyMedium,
                    color = black60,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Clip
                )

            }

        }
    }
}

@Composable
fun JobDetailsCard(
    title : String ,
    companyName : String ,
    companyLogo : String ,
    category : String ,
    jobType : String ,
    location : String ,
    date : String ,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding( MaterialTheme.dimens.space16),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(
                    vertical = MaterialTheme.dimens.space8,
                    horizontal = MaterialTheme.dimens.space16
                )
        ) {
            ImageNetwork(
                imageUrl = companyLogo,
                contentDescription = stringResource(R.string.company_logo),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
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
                    text = title,
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis

                )
                Row (modifier = Modifier.fillMaxWidth() ,
                    horizontalArrangement = Arrangement.SpaceBetween ){
                    Text(
                        text = companyName,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines =2 ,
                        color = black60,
                        overflow = TextOverflow.Clip
                    )
                    Text(
                        text = date,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                }


            }


        }
        Divider(
            color = black60,
            thickness = .5.dp,
            modifier = Modifier.padding(
                MaterialTheme.dimens.space8
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceAround ,
            verticalAlignment = Alignment.CenterVertically
        ){
            ChipJobDetails(cardName = "Category",
                cardValue =category , cardIcon =R.drawable.category )
            ChipJobDetails(cardName = "Location",
                cardValue =location , cardIcon =R.drawable.location )
            ChipJobDetails(cardName = "Job Type",
                cardValue =jobType , cardIcon =R.drawable.type )

        }

    }

}