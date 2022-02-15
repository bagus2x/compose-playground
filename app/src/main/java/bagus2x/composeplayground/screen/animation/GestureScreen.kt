package bagus2x.composeplayground.screen.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import bagus2x.composeplayground.screen.shared.ContentScaffold

@Composable
fun GestureScreen() {
    ContentScaffold(title = "Cross Fade Animation") {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var shape by remember { mutableStateOf("rect") }
            val transition = updateTransition(targetState = shape, label = "transition")
            val size by transition.animateDp(
                label = "size",
                transitionSpec = {
                    spring(stiffness = 100f)
                }
            ) {
                if (it == "circle") 250.dp
                else 100.dp
            }
            val rounded by transition.animateDp(label = "size") {
                if (it == "circle") 125.dp
                else 0.dp
            }
            val color by transition.animateColor(label = "color") {
                if (it == "circle") MaterialTheme.colors.primary
                else MaterialTheme.colors.secondary
            }

            Box(
                modifier = Modifier
                    .size(size)
                    .clip(RoundedCornerShape(rounded))
                    .background(color)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                shape = "circle"
                                tryAwaitRelease()
                                shape = "rect"
                            }
                        )
                    }
            )
        }
    }
}