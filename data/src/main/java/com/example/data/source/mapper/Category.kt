package com.example.data.source.mapper

import com.example.data.source.model.CategoryDto
import com.example.domain.model.Category

fun CategoryDto.toCategory() = Category(
    id = id ?: 0,
    name = name ?: "",
    slug = slug ?: "",
)