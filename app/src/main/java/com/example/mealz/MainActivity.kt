package com.example.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.data.remote.model.Category
import com.example.mealz.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MealsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup(){
        viewModel.getMeals()
        observerOnCategoriesFlow()
    }

    private fun observerOnCategoriesFlow(){
        lifecycleScope.launch {
            viewModel.categories.collect {
                setupRecyclerView(it?.categories)
            }
        }
    }

    private fun setupRecyclerView(categories: List<Category?>?){
        val mealsAdapter = MealsAdapter()
        mealsAdapter.submitList(categories)
        binding.categoryRv.adapter = mealsAdapter
    }


}