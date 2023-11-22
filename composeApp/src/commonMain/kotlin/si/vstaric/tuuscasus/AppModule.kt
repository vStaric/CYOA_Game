package si.vstaric.tuuscasus

import org.koin.dsl.module
import si.vstaric.tuuscasus.game.GameViewModel

fun appModule() = module {
    factory { GameViewModel() }
}