package com.example.mealz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.model.MealsDto
import com.example.domain.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMeals
) : ViewModel() {

    lateinit var categoryJob: Job

    private val _categories: MutableStateFlow<MealsDto?> = MutableStateFlow(null)
    val categories: StateFlow<MealsDto?> = _categories

    fun getMeals() {
        categoryJob = viewModelScope.launch {
            try {
                _categories.value = getMealsUseCase()
            } catch (e: Throwable) {
                Log.d("MealsViewModel", "getMeals: ${e.message}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        categoryJob.cancel()
    }
}