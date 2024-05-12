package com.example.yourmeals.ui.meals


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.BottomSheetDefaults.Elevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults.Elevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults.Elevation
import androidx.compose.material3.SearchBarDefaults.Elevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage


import com.example.yourmeals.ui.model.Response.MealResponse
import com.example.yourmeals.ui.theme.YourMealsTheme

@Composable
fun MealCategoryScreen(navigationCallBack:(String)->Unit) {
    val viewModel:MealViewModel= viewModel() // this is viewmodel is which lifeecycle will be depend on the view composable
    val meal=viewModel.mealsState.value

    LazyColumn(contentPadding = PaddingValues(8.dp)){
        items(meal){
            mealCategory(it,navigationCallBack)
        }
    }
}
@Composable
fun mealCategory(meal:MealResponse,navigationCallBack:(String)->Unit){
    var isExpanded by remember{ mutableStateOf(false) }
    Card (
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .clickable {
                navigationCallBack(meal.id)
            }


    ){
        Row(modifier = Modifier.animateContentSize()) {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
            )      //image
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(15.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.headlineMedium

                )
                Text(
                    text = meal.description,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (isExpanded) 10 else 3,


                )
            }
                Icon(
                    imageVector = if(isExpanded)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand Arrow Icon",
                    modifier = Modifier
                        .padding(15.dp)
                        .align(if(isExpanded)
                            Alignment.Bottom
                        else
                            Alignment.CenterVertically,
                        )
                        .clickable { isExpanded = !isExpanded }
                )

        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YourMealsTheme {
        MealCategoryScreen({})
    }
}