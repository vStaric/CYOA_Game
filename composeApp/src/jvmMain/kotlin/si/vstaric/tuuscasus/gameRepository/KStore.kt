package si.vstaric.tuuscasus.gameRepository

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import net.harawata.appdirs.AppDirsFactory

actual val store: KStore<String> by lazy {
    val appDir: String =
        AppDirsFactory.getInstance().getUserDataDir("si.vstaric.tuuscasus", "1.0.0", "vStaric")
    storeOf(filePath = "${appDir}/saved.json", default = "start_game")
}