package com.example.domain.usecase

import com.example.data.repo.MealsRepo

class GetMeals(
    private val repo: MealsRepo
) {
    suspend operator fun invoke() = repo.getMealsFromRemote()
}