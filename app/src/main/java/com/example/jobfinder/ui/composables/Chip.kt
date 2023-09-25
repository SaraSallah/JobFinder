package com.example.jobfinder.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfinder.ui.theme.black37
import com.example.jobfinder.ui.theme.dimens
import com.example.jobfinder.ui.theme.white

@Composable
fun CategoryChip(
    text: String,
    state : Boolean ,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier.clickable { onClick() },
        colors = if (state) CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
        else CardDefaults.cardColors(Color.Transparent) ,
        border = if (state) BorderStroke(width = 0.dp, color = Color.Transparent)
        else BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer),
        shape = CircleShape
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.dimens.space16, vertical = MaterialTheme.dimens.space6
            ),
            text = text,
            color =if (state) white else black37,
//            style = .copy(baselineShift = BaselineShift(0.3f))
        )

    }
}
@Composable
fun CustomChip(
    text: String,
) {
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onTertiary),
        border = BorderStroke(width = 1.dp, color =MaterialTheme.colorScheme.onErrorContainer),
        shape = CircleShape
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.dimens.space16, vertical = MaterialTheme.dimens.space6
            ),
            text = text,
            color = MaterialTheme.colorScheme.onSecondary,
//            style = .copy(baselineShift = BaselineShift(0.3f))
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryChip() {
    CategoryChip(text = "Designer",state= true){}
    
}
@Preview(showBackground = true)
@Composable
fun PreviewCustomChip() {
    CustomChip(text = "Designer")

}