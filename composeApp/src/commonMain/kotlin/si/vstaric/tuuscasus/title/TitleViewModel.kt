package si.vstaric.tuuscasus.title

import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import si.vstaric.tuuscasus.gameRepository.GameRepository

class TitleViewModel(private val gameRepository: GameRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<TitleUiState> = MutableStateFlow(TitleUiState.NewGame)
    val uiState: CStateFlow<TitleUiState> = CStateFlow(flow = _uiState.asStateFlow())

    fun startGame() {
        viewModelScope.launch {
            gameRepository.resetGame()
            _uiState.value = TitleUiState.StartGame
        }
    }

    init {
        viewModelScope.launch {
            val storyBranchId = gameRepository.loadStoryBranchId()
            if (storyBranchId == "start_game") {
                _uiState.value = TitleUiState.NewGame
            } else {
                _uiState.value = TitleUiState.ContinueGame
            }
        }
    }


}

