package si.vstaric.tuuscasus.game


import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import si.vstaric.tuuscasus.game.model.Action
import si.vstaric.tuuscasus.game.model.Action.ChanceAction
import si.vstaric.tuuscasus.game.model.Action.DefaultAction
import si.vstaric.tuuscasus.game.model.StoryBranch
import si.vstaric.tuuscasus.game.processor.ChanceActionProcessor
import si.vstaric.tuuscasus.game.processor.DefaultActionProcessor
import si.vstaric.tuuscasus.gameRepository.GameRepository
import si.vstaric.tuuscasus.util.Stack

//todo injections
class GameViewModel(
    private val gameRepository: GameRepository,
    private val defaultActionProcessor: DefaultActionProcessor,
    private val chanceActionProcessor: ChanceActionProcessor
) : ViewModel() {

    private val _uiState = MutableStateFlow(StoryBranch("sd", listOf()))

    val uiState: CStateFlow<StoryBranch> =
        CStateFlow(flow = _uiState.asStateFlow()) //todo this is a hack
    val gameStack: Stack<StoryBranch> = Stack() //todo this is a hack

    init {
        viewModelScope.launch {
            val storyBranchId = gameRepository.loadStoryBranchId()
            val storyBranch = gameRepository.getStoryByBranchId(storyBranchId)
            gameStack.push(storyBranch)
            _uiState.value = storyBranch
        }
    }

    fun goBack() {
        viewModelScope.launch {
            if (gameStack.size() > 1) {
                gameStack.pop()
                val storyBranch = gameStack.peek()
                gameRepository.storeStoryBranchId(storyBranch.storyBranchId)
                _uiState.value = storyBranch
            }
        }
    }

    fun nextBranch(action: Action) {
        viewModelScope.launch {
            val nextBranchId = when (action) {
                is ChanceAction -> chanceActionProcessor(action)
                is DefaultAction -> defaultActionProcessor(action)
            }
            val storyBranch = gameRepository.getStoryByBranchId(nextBranchId)
            Napier.d("action: $action, nextBranch: $storyBranch") //todo see this
            gameStack.push(storyBranch)
            gameRepository.storeStoryBranchId(storyBranch.storyBranchId)
            _uiState.value = storyBranch
        }
    }
}


