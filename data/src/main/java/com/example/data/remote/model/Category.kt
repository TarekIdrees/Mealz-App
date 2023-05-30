package com.example.data.remote.model


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val mealId: String?,
    @SerializedName("strCategory")
    val mealName: String?,
    @SerializedName("strCategoryDescription")
    val mealDescription: String?,
    @SerializedName("strCategoryThumb")
    val mealImage: String?
)