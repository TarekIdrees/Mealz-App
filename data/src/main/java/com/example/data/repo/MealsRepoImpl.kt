package com.example.data.repo

import com.example.data.remote.MealsApiService
import com.example.data.remote.model.MealsDto

class MealsRepoImpl(
    private val mealsApiService: MealsApiService,
) : MealsRepo {
    override suspend fun getMealsFromRemote(): MealsDto = mealsApiService.getMeals()
}