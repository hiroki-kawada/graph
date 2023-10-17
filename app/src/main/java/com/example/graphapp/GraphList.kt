package com.example.graphapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GraphList(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Gray)
                    .clickable { navController.navigate("sample") }
            ) {
                Text(
                    text = "SampleList",
                    fontSize = 18.sp
                )
            }
        }
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Gray)
                    .clickable { navController.navigate("horizontal_bar_graph") }
            ) {
                Text(
                    text = "HorizontalBarGraph",
                    fontSize = 18.sp
                )
            }
        }
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Gray)
                    .clickable { navController.navigate("horizontal_bar_animate_graph") }
            ) {
                Text(
                    text = "HorizontalBarAnimateGraph",
                    fontSize = 18.sp
                )
            }
        }
    }
}