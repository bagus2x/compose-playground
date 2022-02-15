package bagus2x.composeplayground.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bagus2x.composeplayground.localprovider.LocalNavController
import bagus2x.composeplayground.screen.animation.AnimationScreen
import bagus2x.composeplayground.screen.animation.CrossFadeScreen
import bagus2x.composeplayground.screen.animation.GestureScreen
import bagus2x.composeplayground.screen.animation.MultipleValueChangeScreen
import bagus2x.composeplayground.screen.home.HomeScreen

object MainRoutes {
    const val MAIN = "home"
    const val ANIMATION = "animation"
}

object AnimationRoutes {
    const val CROSS_FADE = "cross_fade"
    const val MULTIPLE_VALUE_CHANGE = "multiple_value_change"
    const val GESTURE = "gesture_animation"
}

fun NavGraphBuilder.mainRoutes() {
    composable(MainRoutes.MAIN) {
        HomeScreen()
    }
    composable(MainRoutes.ANIMATION) {
        AnimationScreen()
    }
}

fun NavGraphBuilder.animationRoutes() {
    composable(AnimationRoutes.CROSS_FADE) {
        CrossFadeScreen()
    }
    composable(AnimationRoutes.MULTIPLE_VALUE_CHANGE) {
        MultipleValueChangeScreen()
    }
    composable(AnimationRoutes.GESTURE) {
        GestureScreen()
    }
}

@Composable
fun NavGraph() {
    NavHost(
        navController = LocalNavController.current,
        startDestination = MainRoutes.MAIN,
    ) {
        mainRoutes()
        animationRoutes()
    }
}