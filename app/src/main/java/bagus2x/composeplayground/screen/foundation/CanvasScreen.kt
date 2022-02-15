package bagus2x.composeplayground.screen.foundation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import bagus2x.composeplayground.screen.shared.ContentScaffold

@Composable
fun CanvasScreen() {
    ContentScaffold(title = "Canvas") { contentPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            contentAlignment = Alignment.Center
        ) {
            Face()
        }
    }
}

@Composable
fun Face(
    modifier: Modifier = Modifier
) {
    var state by remember { mutableStateOf("smile") }
    val stateDp by animateDpAsState(targetValue = if (state == "smile") 80.dp else (20).dp)

    Canvas(
        modifier = modifier
            .clip(CircleShape)
            .size(200.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        state = "frown"
                        tryAwaitRelease()
                        state = "smile"
                    }
                )
            }
    ) {
        val w = size.width
        val border = 12.dp.toPx()
        val eyesRadius = 10.dp.toPx()

        // Head
        drawCircle(
            color = Color.Yellow,
            style = Fill,
            radius = w / 2
        )
        // Eyes
        drawCircle(
            color = Color.White,
            style = Fill,
            radius = eyesRadius,
            center = Offset(x = center.x - 40.dp.toPx(), y = center.y - 20.dp.toPx())
        )
        drawCircle(
            color = Color.White,
            style = Fill,
            radius = eyesRadius,
            center = Offset(x = center.x + 40.dp.toPx(), y = center.y - 20.dp.toPx())
        )
        // Mouth
        drawPath(
            path = Path().apply {
                moveTo(x = center.x - 40.dp.toPx(), y = center.y + 40.dp.toPx())
                quadraticBezierTo(
                    x1 = center.x,
                    y1 = center.y + stateDp.toPx(),
                    x2 = center.x + 40.dp.roundToPx(),
                    y2 = center.y + 40.dp.roundToPx()
                )
            },
            color = Color.Black,
            style = Stroke(width = border, cap = StrokeCap.Round)
        )
    }
}