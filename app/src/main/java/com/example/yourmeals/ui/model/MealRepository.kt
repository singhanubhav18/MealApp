package com.example.yourmeals.ui.model

import com.example.yourmeals.ui.model.Api.MealWebService
import com.example.yourmeals.ui.model.Response.MealCategoryResponse
import com.example.yourmeals.ui.model.Response.MealResponse

class MealRepository(private val webService: MealWebService= MealWebService()) {
    private var cachedMeal= listOf<MealResponse>()
    suspend fun getMeals():MealCategoryResponse{
        val response=webService.getMeals()
        cachedMeal=response.categories
        return webService.getMeals()
    }
    fun getMeal(id:String):MealResponse?{
        return cachedMeal.firstOrNull(){
            it.id==id
        }
    }
    companion object{
        @Volatile
        private var instance:MealRepository?=null
        fun getInstance()= instance?: synchronized(this){
            instance?:MealRepository().also { instance=it }
        }
    }
}