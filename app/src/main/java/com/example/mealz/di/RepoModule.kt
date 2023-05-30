package com.example.mealz.di

import com.example.data.remote.MealsApiService
import com.example.data.repo.MealsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(
        mealsApiService: MealsApiService
    ) = MealsRepoImpl(mealsApiService)
}