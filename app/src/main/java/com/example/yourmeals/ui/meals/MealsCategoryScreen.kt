package com.example.yourmeals.ui.meals


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

import com.example.yourmeals.ui.model.Response.MealResponse
import com.example.yourmeals.ui.theme.YourMealsTheme

@Composable
fun MealCategoryScreen() {
    val viewModel:MealViewModel= viewModel() // this is viewmodel is which lifeecycle will be depend on the view composable
    val meal=viewModel.mealsState.value

    LazyColumn(contentPadding = PaddingValues(2.dp)){
        items(meal){
            mealCategory(it)
        }
    }
}
@Composable
fun mealCategory(meal:MealResponse){
    Card (
        shape = RoundedCornerShape(5.dp),
            modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)


    ){
        Row {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(4.dp)
            )      //image
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(15.dp)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.headlineMedium

                )
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YourMealsTheme {
        MealCategoryScreen()
    }
}