package bagus2x.composeplayground.screen.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ShapeScreen() {
    Box(
        modifier = Modifier
            .clip(CustomShape)
            .size(200.dp)
            .background(MaterialTheme.colors.primary)
    )
}

private val CustomShape = GenericShape { size, _ ->
    val w = size.width
    val h = size.height

    moveTo(0f, 0f)
    lineTo(w, 0f)
    lineTo(w, h)
    close()
}