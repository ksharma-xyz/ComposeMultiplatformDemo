package xyz.ksharma.composemultiplatform.splash

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize().systemBarsPadding(),
        contentAlignment = Alignment.Center,
    ) {
        Text("Home Screen", modifier = Modifier.clickable {
            onClick()
        })
    }
}


@Composable
fun DetailScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize().systemBarsPadding(),
        contentAlignment = Alignment.Center,
    ) {
        Text("Go back", modifier = Modifier.clickable {
            onBackClick()
        })

        Text("Detail Screen")
    }
}
