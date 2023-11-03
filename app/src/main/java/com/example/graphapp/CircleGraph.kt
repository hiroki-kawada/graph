package com.example.graphapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.graphapp.ui.theme.GraphAppTheme

@Composable
fun CircleGraph(
    modifier: Modifier = Modifier
) {
    val sampleValues =
        listOf(CircleData(23, Color.Blue), CircleData(32, Color.Red), CircleData(45, Color.Green))
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Canvas(
            modifier = modifier
                .width(500.dp)
                .height(500.dp)
        ) {
            var total = 0f
            sampleValues.forEach {
                total += it.value.toFloat()
            }
            var startAngle = 0f
            for (i in sampleValues.indices) {
                val ratio = sampleValues[i].value / total * 100
                val angle = (ratio * 3.6).toFloat()
                drawArc(
                    sampleValues[i].color,
                    startAngle = startAngle - 90,
                    sweepAngle = angle,
                    useCenter = true
                )
                startAngle += angle
            }
        }
    }
}

data class CircleData(val value: Int, val color: Color)

@Preview(showBackground = true)
@Composable
fun CircleGraphPreview() {
    GraphAppTheme {
        CircleGraph()
    }
}