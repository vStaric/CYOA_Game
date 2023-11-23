package si.vstaric.tuuscasus

import org.koin.dsl.module
import si.vstaric.tuuscasus.game.GameViewModel
import si.vstaric.tuuscasus.game.processor.ChanceActionProcessor
import si.vstaric.tuuscasus.game.processor.DefaultActionProcessor
import si.vstaric.tuuscasus.gameRepository.GameRepository
import si.vstaric.tuuscasus.gameRepository.StoryDataSource
import si.vstaric.tuuscasus.gameRepository.ValueStore
import si.vstaric.tuuscasus.title.TitleViewModel

fun appModule() = module {
    factory { GameViewModel(get(), DefaultActionProcessor(), ChanceActionProcessor()) }

    factory { StoryDataSource() }

    factory { ValueStore() }

    factory { GameRepository(get(), get()) }

    factory { TitleViewModel(get()) }
}