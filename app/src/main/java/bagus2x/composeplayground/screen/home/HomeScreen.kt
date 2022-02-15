package bagus2x.composeplayground.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bagus2x.composeplayground.localprovider.LocalNavController
import bagus2x.composeplayground.navigation.MainRoutes
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun HomeScreen() {
    val navController = LocalNavController.current
    val indexes = rememberSaveable {
        listOf(
            MainRoutes.ANIMATION,
            MainRoutes.FOUNDATION
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Playground")
                }
            )
        },
        modifier = Modifier.systemBarsPadding()
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            contentPadding = PaddingValues(20.dp)
        ) {
            items(indexes, key = { it }) { route ->
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate(route)
                    }
                ) {
                    Text(text = route)
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}