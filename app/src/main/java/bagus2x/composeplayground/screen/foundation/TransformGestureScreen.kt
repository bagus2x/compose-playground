package bagus2x.composeplayground.screen.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import bagus2x.composeplayground.screen.shared.ContentScaffold
import kotlin.math.roundToInt

@Composable
fun TransformGestureScreen() {
    ContentScaffold(title = "Transform Gesture") { contentPadding ->
        var angle by remember { mutableStateOf(0f) }
        var zoom by remember { mutableStateOf(1f) }
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
        ) {
            Box(
                modifier = Modifier
                    .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                    .graphicsLayer {
                        scaleX = zoom
                        scaleY = zoom
                        rotationZ = angle
                    }
                    .size(200.dp)
                    .background(MaterialTheme.colors.primary)
                    .pointerInput(Unit) {
                        detectTransformGestures(
                            onGesture = { _, pan, gestureZoom, gestureRotation ->
                                angle += gestureRotation
                                zoom *= gestureZoom
                                offsetX += pan.x
                                offsetY += pan.y
                            }
                        )
                    }
            )
        }
    }
}