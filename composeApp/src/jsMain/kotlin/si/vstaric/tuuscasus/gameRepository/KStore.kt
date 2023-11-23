package si.vstaric.tuuscasus.gameRepository

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storage.storeOf

actual val store: KStore<String> by lazy {
    storeOf("saved", "start_game")
}