package com.example.graphapp

import android.opengl.Visibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.graphapp.ui.theme.GraphAppTheme

@Composable
fun CircleAnimateGraph(
    modifier: Modifier = Modifier
) {
    val sampleValues =
        listOf(
            CircleAnimateData(23, Color.Blue), CircleAnimateData(32, Color.Red),
            CircleAnimateData(45, Color.Green)
        )
    val animationFlag = remember { mutableStateOf(false) }
    val animateAngleList = mutableListOf<Float>()
    for (i in sampleValues.indices) {
        val durationMillis = 500 * i
        val animateWidth by animateFloatAsState(
            targetValue = if (animationFlag.value) 1f else 0f,
            animationSpec = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing,
                delayMillis = durationMillis
            )
        )
        animateAngleList.add(animateWidth)
    }
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
            animationFlag.value = true
            for (i in sampleValues.indices) {
                val ratio = sampleValues[i].value / total * 100
                val angle = (ratio * 3.6).toFloat()
                drawArc(
                    color = sampleValues[i].color,
                    startAngle = startAngle - 90,
                    sweepAngle = animateAngleList[i] * angle,
                    useCenter = true
                )
                startAngle += angle
            }
        }
    }
}

data class CircleAnimateData(val value: Int, val color: Color)

@Preview(showBackground = true)
@Composable
fun CircleAnimateGraphPreview() {
    GraphAppTheme {
        CircleAnimateGraph()
    }
}