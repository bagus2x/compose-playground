package bagus2x.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import bagus2x.composeplayground.localprovider.LocalProviders
import bagus2x.composeplayground.navigation.NavGraph
import bagus2x.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ComposePlaygroundTheme {
                val navController = rememberNavController()
                LocalProviders(navController = navController) {
                    NavGraph()
                }
            }
        }
    }
}