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
    val sampleValues = listOf(200, 300, 400, 500, 650)

    Canvas(modifier = modifier.fillMaxSize()) {
        val graphHeight = (size.height / sampleValues.size)

        for (i in sampleValues.indices) {
            drawRect(
                topLeft = Offset(0f, (graphHeight * i)),
                color = Color.Red,
                size = Size(width = sampleValues[i].toFloat(), height = graphHeight - 10)
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