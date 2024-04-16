package com.nimbuzz.photoapp.di

import com.nimbuzz.photoapp.data.datasource.remote.ApiService
import com.nimbuzz.photoapp.data.repository.NimBuzzRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    /**
     * Provides RemoteDataRepository for access api service method
     */
    @Singleton
    @Provides
    fun provideMovieRepository(
        apiService: ApiService,
    ): NimBuzzRepository {
        return NimBuzzRepository(
            apiService
        )
    }

}