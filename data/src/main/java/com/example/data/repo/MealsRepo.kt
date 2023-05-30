package com.example.data.repo

import com.example.data.remote.model.MealsDto

interface MealsRepo {
    suspend fun getMealsFromRemote(): MealsDto
}