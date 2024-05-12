package com.example.yourmeals.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourmeals.ui.model.MealRepository
import com.example.yourmeals.ui.model.Response.MealCategoryResponse
import com.example.yourmeals.ui.model.Response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealViewModel(val respository:MealRepository= MealRepository()): ViewModel() {

    val mealsState: MutableState<List<MealResponse>> =   mutableStateOf(emptyList<MealResponse>())

    init {
    viewModelScope.launch (Dispatchers.IO){
        val meal=getMeals()
        mealsState.value=meal
    }
}

    private suspend fun getMeals():List<MealResponse>{
       return respository.getMeals().categories
    }
}