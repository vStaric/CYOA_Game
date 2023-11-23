package si.vstaric.tuuscasus.gameRepository

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import platform.Foundation.NSHomeDirectory

actual val store: KStore<String> by lazy {
    storeOf(filePath = "${NSHomeDirectory()}/saved.json", default = "start_game")
}