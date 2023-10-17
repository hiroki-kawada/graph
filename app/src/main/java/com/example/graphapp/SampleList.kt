package com.example.graphapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.graphapp.ui.theme.GraphAppTheme

@Composable
fun SampleList(
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item { CircleCanvas() }
        item { RectCanvas() }
        item { PathCanvas() }
        item { ArcCanvas() }
        item { ClipPathCanvas() }
    }
}

@Composable
fun CircleCanvas() {
    Canvas(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {
        drawCircle(Color.Blue, radius = 20.dp.toPx())
    }
}

@Composable
fun RectCanvas() {
    Canvas(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {
        drawRect(Color.Blue, topLeft = Offset(10F, 20f), size = size / 2F)
    }
}

@Composable
fun PathCanvas() {
    Canvas(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {

        val path = Path()
        path.moveTo(size.width, 0F)
        path.lineTo(size.width, size.height)
        path.lineTo(0F, size.height)
        drawPath(path = path, Color.Blue)
    }
}


@Composable
fun ArcCanvas() {
    Canvas(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {
        drawArc(Color.Blue, startAngle = 0f, sweepAngle = 90f, useCenter = true)
    }
}

@Composable
fun ClipPathCanvas() {
    Canvas(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {

        val path = Path()
        path.moveTo(size.width, 0F)
        path.lineTo(size.width, size.height)
        path.lineTo(0F, size.height)
        clipPath(
            path = path, clipOp = ClipOp.Intersect
        ) {
            // 三角形
            drawPath(path = path, Color.Blue)

            //クリップ用の短形
            drawRect(
                Color.Red, size = Size(
                    0.5f * size.width,
                    size.height
                )
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun CircleCanvasPreview() {
    GraphAppTheme {
        CircleCanvas()
    }
}

@Preview(showBackground = true)
@Composable
fun RectCanvasPreview() {
    GraphAppTheme {
        RectCanvas()
    }
}

@Preview(showBackground = true)
@Composable
fun PathCanvasPreview() {
    GraphAppTheme {
        PathCanvas()
    }
}

@Preview(showBackground = true)
@Composable
fun ArcCanvasPreview() {
    GraphAppTheme {
        ArcCanvas()
    }
}

@Preview(showBackground = true)
@Composable
fun ClipPathCanvasPreview() {
    GraphAppTheme {
        ClipPathCanvas()
    }
}