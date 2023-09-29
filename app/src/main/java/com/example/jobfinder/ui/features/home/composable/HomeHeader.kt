package com.example.jobfinder.ui.features.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfinder.R
import com.example.jobfinder.ui.theme.dimens
import com.example.jobfinder.ui.theme.primary200

@Composable
fun HomeHeader(
    onCLick :() -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(MaterialTheme.dimens.space36),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(.7f) ,
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space8),
            horizontalAlignment = Alignment.Start

        ) {
            Text(
                text = "Welcome Back !",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text ="Discover ideal career opportunities with us." ,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        Card( modifier = Modifier
            .size(MaterialTheme.dimens.space40),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = primary200,

            )
        ) {
            Box(
                modifier = Modifier.
                fillMaxSize()
                .clickable {onCLick() },
                contentAlignment = Alignment.Center
            ) {
            Icon(
                modifier = Modifier
                    .size(MaterialTheme.dimens.space24),
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = stringResource(id = R.string.search),
                tint = MaterialTheme.colorScheme.onPrimary,

            )

        }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun HomeHeaderPreview() {
    HomeHeader {

    }

}