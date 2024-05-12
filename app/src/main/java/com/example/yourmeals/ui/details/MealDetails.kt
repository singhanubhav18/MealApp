package com.example.yourmeals.ui.details

import android.view.animation.Transformation
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.transform.CircleCropTransformation
import com.example.yourmeals.ui.model.Response.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse?){
    Column {
        Row (verticalAlignment = Alignment.Top){

            Card(modifier = Modifier.fillMaxWidth(.5f).padding(top = 10.dp)) {
                AsyncImage(
                    model = meal?.imageUrl,
                   
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(8.dp)

                )
            }
            Text(text = meal?.name?:"default name", modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically)

            )
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Change state of Profile Picture")
        }
    }
}