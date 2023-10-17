package com.example.graphapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.graphapp.ui.theme.GraphAppTheme

@Composable
fun HorizontalBarGraph(
    modifier: Modifier = Modifier
) {
    val sampleValues = listOf(300, 500, 700, 900, 1100)

    Canvas(modifier = modifier.fillMaxSize()) {
        val graphWidth = size.width / sampleValues.size

        for (i in sampleValues.indices) {
            drawRect(
                topLeft = Offset(graphWidth * i, size.height),
                color = Color.Red,
                size = Size(width = graphWidth - 10, height = -sampleValues[i].toFloat())
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HorizontalBarGraphPreview() {
    GraphAppTheme {
        HorizontalBarGraph()
    }
}