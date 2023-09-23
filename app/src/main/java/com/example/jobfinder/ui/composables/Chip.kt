package com.example.jobfinder.ui.composables

import androidx.compose.foundation.BorderStroke
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
import com.example.jobfinder.ui.theme.dimens

@Composable
fun CategoryChip(
    text: String,
) {
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        border = BorderStroke(width = 0.dp, color = Color.Transparent),
        shape = CircleShape
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.dimens.space16, vertical = MaterialTheme.dimens.space6
            ),
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
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
    CategoryChip(text = "Designer")
    
}
@Preview(showBackground = true)
@Composable
fun PreviewCustomChip() {
    CustomChip(text = "Designer")

}