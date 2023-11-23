package si.vstaric.tuuscasus.gameRepository

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import si.vstaric.tuuscasus.AndroidApp


actual val store: KStore<String> by lazy {
    storeOf(filePath = "${AndroidApp.INSTANCE.filesDir.path}/saved.json", default = "start_game")
}