package com.example.data.remote


import com.example.data.remote.model.MealsDto
import retrofit2.http.GET

interface MealsApiService {
    @GET("categories.php")
    suspend fun getMeals(): MealsDto
}