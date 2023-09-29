package com.example.jobfinder.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.jobfinder.R
import com.example.jobfinder.ui.theme.Shapes
import com.example.jobfinder.ui.theme.black87
import com.example.jobfinder.ui.theme.dimens
import com.example.jobfinder.ui.theme.primary200

@Composable
fun CategoryDesign(
    categoryName : String ,
    categoryIcon :Int,
    categorySize : Int


    ) {
    Column ( horizontalAlignment = Alignment.CenterHorizontally){
        Card( modifier = Modifier
            .size(MaterialTheme.dimens.space86),
            shape = Shapes.large,
            colors = CardDefaults.cardColors(
                containerColor = primary200,

                )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
//                    .clickable {onCLick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(MaterialTheme.dimens.space32),
                    painter = painterResource(id = categoryIcon),
                    contentDescription = stringResource(id = R.string.search),
                    tint = MaterialTheme.colorScheme.onPrimary,

                    )

            }
        }
            Text(
                text = categoryName,
                style = MaterialTheme.typography.bodyMedium,
                color = black87,
                maxLines = 1,
                overflow = TextOverflow.Visible

            )

    }


}