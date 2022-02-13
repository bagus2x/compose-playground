package bagus2x.composeplayground.screen.animation

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import bagus2x.composeplayground.screen.shared.ContentScaffold

@Composable
fun CrossFadeScreen() {
    ContentScaffold(title = "Cross Fade Animation") {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var shape by remember { mutableStateOf("circle") }

            Button(
                onClick = { shape = if (shape == "circle") "rect" else "circle" }
            ) {
                Text(text = "Circle/Rect")
            }
            Spacer(modifier = Modifier.height(50.dp))
            Crossfade(targetState = shape, animationSpec = tween(3000)) {
                if (it == "rect") {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(MaterialTheme.colors.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = shape)
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.secondary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = shape)
                    }
                }
            }
        }
    }
}