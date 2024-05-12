package com.example.yourmeals.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.yourmeals.ui.model.MealRepository
import com.example.yourmeals.ui.model.Response.MealResponse

class MealDetailsViewModel (private val savedStateHandle:SavedStateHandle):ViewModel(){
    val respository: MealRepository = MealRepository.getInstance()
    var mealState= mutableStateOf<MealResponse?>(null)

    init {
        val mealId=savedStateHandle.get<String>("meal_category_id")?:""
        mealState.value=respository.getMeal(mealId)
    }

}