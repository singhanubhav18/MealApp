package com.example.yourmeals.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.yourmeals.ui.details.MealDetailsScreen
import com.example.yourmeals.ui.details.MealDetailsViewModel
import com.example.yourmeals.ui.meals.MealCategoryScreen
import com.example.yourmeals.ui.theme.YourMealsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel by ViewModel<MealViewModel>()
        setContent {
            YourMealsTheme {
                FoodizeApp()
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
private fun FoodizeApp(){
    val navController= rememberNavController()
    NavHost(navController, startDestination ="destination_meal_list"){
        composable(route="destination_meal_list"){
            MealCategoryScreen{navigationMealId->
                navController.navigate("destination_meal_details/$navigationMealId")
            }
        }
        composable(
            route="destination_meal_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id"){
                type= NavType.StringType
            })
        ){
            val viewmodel:MealDetailsViewModel= viewModel()
                MealDetailsScreen(viewmodel.mealState.value)
            }
    }
}



