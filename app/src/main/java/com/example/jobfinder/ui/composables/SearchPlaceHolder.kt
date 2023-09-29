package com.example.jobfinder.ui.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.jobfinder.R
import com.example.jobfinder.ui.theme.black60
import com.example.jobfinder.ui.theme.dimens

@Composable
fun SearchPlaceHolder(state: Boolean) {
    ContentVisibility(state = state) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.dimens.space16),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.career),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            Text(
                text = "Explore diverse job options here.",
                style = MaterialTheme.typography.bodyMedium,
                color = black60,
                textAlign = TextAlign.Center,
            )

        }
    }
}

@Preview
@Composable
fun PreviewSearchPlaceHolder() {
    SearchPlaceHolder(state = true)
}