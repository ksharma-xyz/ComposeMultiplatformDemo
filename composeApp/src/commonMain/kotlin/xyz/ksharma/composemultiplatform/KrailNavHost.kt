package xyz.ksharma.composemultiplatform

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import xyz.ksharma.composemultiplatform.splash.DetailScreen
import xyz.ksharma.composemultiplatform.splash.HomeScreen

@Composable
fun ComposeNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier.fillMaxSize(),
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onClick = {
                    navController.navigate(
                        route = DetailRoute("1"),
                        navOptions = NavOptions.Builder()
                            .setLaunchSingleTop(true)
                            .build(),
                    )
                },
            )
        }

        composable<DetailRoute> {
            DetailScreen(
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}

@Serializable
private data object HomeScreen

@Serializable
private data object DetailScreen

@Serializable
private data object HomeRoute


@Serializable
private data class DetailRoute(val id: String)
