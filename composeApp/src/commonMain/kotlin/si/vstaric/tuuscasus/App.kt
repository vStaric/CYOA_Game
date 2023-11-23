package si.vstaric.tuuscasus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import io.github.aakira.napier.Napier
import org.koin.compose.KoinApplication
import si.vstaric.tuuscasus.title.TitleScreen

@Composable
internal fun App() {
    Napier.d("App started")

    KoinApplication(application = {
        modules(appModule())
    }) {
        Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)) {
            Navigator(TitleScreen)
        }
    }
}