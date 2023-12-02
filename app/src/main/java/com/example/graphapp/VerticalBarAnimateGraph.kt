package com.example.graphapp

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.graphapp.ui.theme.GraphAppTheme

@Composable
fun VerticalAnimateBarGraph(
    modifier: Modifier = Modifier
) {
    val sampleValues = listOf(300, 500, 700, 900, 1100)

    val animationFlag = remember { mutableStateOf(false) }

    val animateHeightList = mutableListOf<Float>()
    for (i in sampleValues.indices) {
        val durationMillis = 500 * i
        val animateHeight by animateFloatAsState(
            targetValue = if (animationFlag.value) 1f else 0f,
            animationSpec = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing,
                delayMillis = durationMillis
            )
        )
        animateHeightList.add(animateHeight)
    }


    Canvas(modifier = modifier.fillMaxSize()) {
        val graphWidth = size.width / sampleValues.size
        animationFlag.value = true
        for (i in sampleValues.indices) {
            drawRect(
                topLeft = Offset(graphWidth * i, size.height),
                color = Color.Red,
                size = Size(
                    width = graphWidth - 10,
                    height = animateHeightList[i] * -sampleValues[i].toFloat()
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerticalAnimateBarGraphPreview() {
    GraphAppTheme {
        VerticalAnimateBarGraph()
    }
}