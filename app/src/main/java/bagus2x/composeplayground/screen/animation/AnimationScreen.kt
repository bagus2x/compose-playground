package bagus2x.composeplayground.screen.animation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import bagus2x.composeplayground.navigation.AnimationRoutes
import bagus2x.composeplayground.screen.shared.IndexScaffold

@Composable
fun AnimationScreen() {
    IndexScaffold(
        title = "Animation",
        routes = rememberSaveable {
            listOf(
                AnimationRoutes.CROSS_FADE,
                AnimationRoutes.MULTIPLE_VALUE_CHANGE,
                AnimationRoutes.GESTURE
            )
        }
    )
}