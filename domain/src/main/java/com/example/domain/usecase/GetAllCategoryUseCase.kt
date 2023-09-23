package com.example.domain.usecase

import com.example.domain.model.Category
import com.example.domain.repository.JobFinderRepository
import javax.inject.Inject

class GetAllCategoryUseCase @Inject constructor(
    private val jobFinderRepository: JobFinderRepository,
) {
    suspend operator fun invoke(): List<Category> =
        jobFinderRepository.getAllCategory()

}