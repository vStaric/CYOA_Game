package si.vstaric.tuuscasus.title

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.compose.koinInject
import si.vstaric.tuuscasus.game.GameScreen

object TitleScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinInject<TitleViewModel>()
        val navigator = LocalNavigator.currentOrThrow

        val uiState by viewModel.uiState.collectAsState()

        if (uiState == TitleUiState.StartGame) {
            navigator.push(GameScreen)
        }

        TitleScreen(
            uiState,
            onNewGame = { viewModel.startGame() },
            onContinueGame = { navigator.push(GameScreen) }
        )
    }
}

@Composable
private fun TitleScreen(
    titleUiState: TitleUiState,
    onNewGame: () -> Unit,
    onContinueGame: () -> Unit
) {
    Column(
        modifier = Modifier.padding(32.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Tuus casus",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { onNewGame() },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "New Game")
        }
        if (titleUiState == TitleUiState.ContinueGame) {
            Button(
                onClick = { onContinueGame() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Continue")
            }
        }
    }
}
