package com.example.jobfinder.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jobfinder.ui.features.category.CategoryUiState
import com.example.jobfinder.ui.theme.dimens

@Composable
fun CategoriesLazyRow(
    categories: List<CategoryUiState>,
    onClick: () -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .padding(MaterialTheme.dimens.space16),
        contentPadding = PaddingValues(MaterialTheme.dimens.space16),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space16)
    ) {
        items(categories.size) { index ->
            CategoryChip(text = categories[index].name)

        }
    }

}