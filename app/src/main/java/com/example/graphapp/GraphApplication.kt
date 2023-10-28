package com.example.graphapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GraphApplication(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        content = { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                NavHost(navController = navController, startDestination = "list") {
                    //サンプルリスト画面
                    composable("list") {
                        GraphList(
                            navController = navController,
                            modifier = modifier
                        )
                    }
                    //横棒グラフ画面
                    composable("horizontal_bar_graph") {
                        HorizontalBarGraph(
                            modifier = modifier
                        )
                    }
                    //横棒グラフアニメーション画面
                    composable("horizontal_bar_animate_graph") {
                        HorizontalBarAnimateGraph(
                            modifier = modifier
                        )
                    }
                    //縦棒グラフ画面
                    composable("vertical_bar_graph") {
                        VerticalBarGraph(
                            modifier = modifier
                        )
                    }
                    //縦棒グラフアニメーション画面
                    composable("vertical_animate_bar_graph") {
                        VerticalAnimateBarGraph(
                            modifier = modifier
                        )
                    }
                }

            }
        }
    )
}