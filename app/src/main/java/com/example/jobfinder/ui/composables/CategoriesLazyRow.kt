package com.example.jobfinder.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jobfinder.ui.features.category.CategoryUiState
import com.example.jobfinder.ui.theme.dimens

@Composable
fun CategoriesLazyRow(
    categories: List<CategoryUiState>,
    onClick: (categoryId: Int) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .wrapContentWidth(),
        contentPadding = PaddingValues(MaterialTheme.dimens.space16),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space16)
    ) {
        items(categories, key = { it.id }) { category ->
            CategoryChip(
                text = category.name,
                state = category.selectedCategory,
                onClick = { onClick(category.id) }
            )

        }
    }
}

@Composable
fun CategoriesLazyRowDesign(
    categories: List<com.example.jobfinder.ui.features.home.CategoryUiState>,
//    onClick: (categoryId: Int) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .wrapContentWidth(),
        contentPadding = PaddingValues(MaterialTheme.dimens.space16),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.space16)
    ) {
        items(categories, key = { it.id }) { category ->
            CategoryDesign(
                categoryName = category.name,
                categoryIcon = category.categoryIcon,
                categorySize = categories.size
            )

        }
    }
}