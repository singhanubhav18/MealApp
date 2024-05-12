package com.example.yourmeals.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.yourmeals.ui.meals.MealCategoryScreen
import com.example.yourmeals.ui.theme.YourMealsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel by ViewModel<MealViewModel>()
        setContent {
            YourMealsTheme {
                    MealCategoryScreen()
            }
        }
    }
}



