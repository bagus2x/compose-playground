package bagus2x.composeplayground.localprovider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import com.google.accompanist.insets.ProvideWindowInsets

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("NavController not found")
}

@Composable
fun LocalProviders(
    navController: NavHostController,
    content: @Composable () -> Unit
) {

    ProvideWindowInsets {
        CompositionLocalProvider(
            LocalNavController provides navController,
            content = content
        )
    }
}