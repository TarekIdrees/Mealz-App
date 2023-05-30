package com.example.data.remote.model


import com.google.gson.annotations.SerializedName

data class MealsDto(
    @SerializedName("categories")
    val categories: List<Category?>?
)