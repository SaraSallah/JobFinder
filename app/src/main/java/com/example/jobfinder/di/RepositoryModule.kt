package com.example.jobfinder.di

import com.example.data.repository.JobFinderRepositoryImp
import com.example.domain.repository.JobFinderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindJobFinderRepository(repository: JobFinderRepositoryImp): JobFinderRepository
}

