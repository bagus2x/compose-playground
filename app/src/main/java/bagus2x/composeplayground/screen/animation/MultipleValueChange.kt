package bagus2x.composeplayground.screen.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import bagus2x.composeplayground.screen.shared.ContentScaffold

@Composable
fun MultipleValueChangeScreen() {
    ContentScaffold(title = "Cross Fade Animation") {
        var value by rememberSaveable { mutableStateOf(false) }
        val transition = updateTransition(value, label = "value")
        val color by transition.animateColor(label = "color") {
            if (it) MaterialTheme.colors.primary else MaterialTheme.colors.secondary
        }
        val corner by transition.animateDp(label = "dp") {
            if (it) 100.dp else 0.dp
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = { value = !value }
            ) {
                Text(text = "True/False")
            }
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(corner))
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Text(text = value.toString())
            }
        }
    }
}