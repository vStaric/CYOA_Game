import androidx.compose.ui.window.ComposeUIViewController
import si.vstaric.tuuscasus.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
