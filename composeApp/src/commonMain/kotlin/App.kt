import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.anime_list.AnimeListScreen
import presentation.auth.AuthScreen
import presentation.theme.OtakuHubTheme

@Composable
@Preview
fun App() {
    OtakuHubTheme {
        val navController = rememberNavController()

        val bottomNavItems = listOf(
            BottomNavItem(
                imageVector = Icons.Filled.Home,
                label = "Home",
                route = AnimeListScreen.SCREEN_ID
            ),
            BottomNavItem(
                imageVector = Icons.Filled.Search,
                label = "Search",
                route = AnimeListScreen.SCREEN_ID
            ),
            BottomNavItem(
                imageVector = Icons.Filled.Favorite,
                label = "Favorites",
                route = AnimeListScreen.SCREEN_ID
            )
        )

        var selectedTabIndex by rememberSaveable {
            mutableStateOf(0)
        }

        Surface(
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .windowInsetsPadding(WindowInsets.statusBars)
        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar(
                        modifier = Modifier.height(80.dp)
                    ) {
                        bottomNavItems.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedTabIndex == index,
                                icon = {
                                    Icon(
                                        imageVector = item.imageVector,
                                        contentDescription = item.label
                                    )
                                },
                                label = {
                                    Text(
                                        text = item.label,
                                        fontSize = 12.sp
                                    )
                                },
                                onClick = {}
                            )
                        }
                    }
                }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = AuthScreen.SCREEN_ID
                ) {
                    composable(AnimeListScreen.SCREEN_ID) {
                        AnimeListScreen.Content(navController)
                    }
                    composable(AuthScreen.SCREEN_ID) {
                        AuthScreen.Content(navController)
                    }
                }
            }
        }
    }
}

data class BottomNavItem(
    val imageVector: ImageVector,
    val label: String,
    val route: String,
)