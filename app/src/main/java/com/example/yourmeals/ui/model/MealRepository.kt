package com.example.yourmeals.ui.model

import com.example.yourmeals.ui.model.Api.MealWebService
import com.example.yourmeals.ui.model.Response.MealCategoryResponse

class MealRepository(private val webService: MealWebService= MealWebService()) {
    suspend fun getMeals():MealCategoryResponse{
        return webService.getMeals()
    }
}