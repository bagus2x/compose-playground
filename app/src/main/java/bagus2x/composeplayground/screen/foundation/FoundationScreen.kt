package bagus2x.composeplayground.screen.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import bagus2x.composeplayground.navigation.FoundationRoutes
import bagus2x.composeplayground.screen.shared.IndexScaffold

@Composable
fun FoundationScreen() {
    IndexScaffold(
        title = "Foundation",
        routes = rememberSaveable {
            listOf(
                FoundationRoutes.CANVAS,
                FoundationRoutes.SHAPE,
                FoundationRoutes.TRANSFORM_GESTURE
            )
        }
    )
}