package si.vstaric.tuuscasus.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.seiko.imageloader.rememberImagePainter
import io.github.skeptick.libres.compose.painterResource
import org.koin.compose.koinInject
import si.vstaric.tuuscasus.Res
import si.vstaric.tuuscasus.game.COYAState.Dialogue
import si.vstaric.tuuscasus.game.COYAState.Image
import si.vstaric.tuuscasus.game.COYAState.Story
import si.vstaric.tuuscasus.game.COYAState.StoryActions

object GameScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinInject<GameViewModel>()
        GameScreen(viewModel)
    }
}

@Composable
private fun GameScreen(viewModel: GameViewModel) {
    val storyBranch by viewModel.uiState.collectAsState()
    StoryBranch(
        storyBranch = storyBranch,
        onActionClick = { viewModel.nextBranch(it) },
        onCharacterClick = {}
    )
}

@Composable
private fun StoryBranch(
    storyBranch: StoryBranch,
    onActionClick: (Action) -> Unit,
    onCharacterClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (item in storyBranch.list) {
            when (item) {
                is Dialogue -> {
                    DialogBubble(dialogue = item, onCharacterClick = onCharacterClick)
                }

                is Image -> {
                    StoryImage(url = item.imageUrl)
                }

                is StoryActions -> {
                    Actions(
                        onClick = onActionClick,
                        list = item.defaultActions
                    )
                }

                is Story -> {
                    StoryText(item)
                }
            }
        }
    }
}

@Composable
private fun StoryText(item: Story) {
    DialogueBubbleLayout {
        Row(modifier = Modifier.padding(16.dp)) {
            DialogText(item.text)
        }
    }
}

@Composable
fun DialogBubble(
    dialogue: Dialogue,
    onCharacterClick: (String) -> Unit
) {
    when (dialogue.type) {
        DialogType.LEFT -> {
            DialogueBubbleLayout {
                Row(modifier = Modifier.padding(16.dp)) {
                    Character(dialogue.character, onCharacterClick)
                    DialogText(dialogue.text, modifier = Modifier.weight(1f))
                }
            }
        }

        DialogType.RIGHT -> {
            DialogueBubbleLayout {
                Row(modifier = Modifier.padding(16.dp)) {
                    DialogText(dialogue.text, modifier = Modifier.weight(1f))
                    Character(dialogue.character, onCharacterClick)
                }
            }
        }
    }
}


@Composable
private fun DialogueBubbleLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(modifier = modifier.padding(16.dp)) {
        content()
    }
}

@Composable
private fun DialogText(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(horizontal = 8.dp),
        text = text
    )
}

@Composable
private fun Character(character: Character, onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.clickable { onClick(character.id) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(character.avatarIcon ?: Res.image.hero),
            contentDescription = "Image",
            alignment = Alignment.Center,
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 0.dp)
                .widthIn(max = 80.dp),
            text = character.name,
        )
    }
}

@Composable
private fun StoryImage(
    url: String
) {
    DialogueBubbleLayout {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberImagePainter(url),
                contentDescription = "Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
private fun Actions(
    onClick: (Action) -> Unit,
    list: List<Action>
) {
    DialogueBubbleLayout {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            for (action in list) {
                Button(
                    onClick = { onClick(action) },
                    enabled = action.state == ActionState.ENABLED,
                    //todo style for selected
                ) {
                    Text(text = action.text)
                }
            }
        }
    }
}

//todo fix preview
//
//@Preview
//@Composable
//fun DefaultPreview() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        StoryImage(
//            url = "https://www.milwaukeemag.com/wp-content/uploads/2023/05/0523-Explore-Labyrinth-IMG_0128-2048x1152.jpg"
//        )
//        DialogBubble(
//            dialogue = Dialogue(
//                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
//                type = DialogType.LEFT
//            )
//        )
//        DialogBubble(
//            dialogue = Dialogue(
//                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
//                type = DialogType.RIGHT
//            )
//        )
//        DialogBubble(
//            dialogue = Dialogue(
//                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
//                type = DialogType.CENTER
//            )
//        )
//        DialogBubble(
//            dialogue = Dialogue(
//                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
//                type = DialogType.LEFT
//            )
//        )
//        DialogueBubbleLayout {
//            Actions(
//                onClick = {}, list = listOf(
//                    Action.DefaultAction(
//                        actionId = "1",
//                        text = "Action 1",
//                        state = ActionState.ENABLED,
//                        nextStoryBranchId = "1"
//                    ),
//                    Action.DefaultAction(
//                        actionId = "2", text = "Action 2", state = ActionState.DISABLED,
//                        nextStoryBranchId = "1"
//                    ),
//                    Action.DefaultAction(
//                        actionId = "3", text = "Action 3", state = ActionState.SELECTED,
//                        nextStoryBranchId = "1"
//                    ),
//                )
//            )
//        }
//    }
//}


enum class ActionState {
    ENABLED, DISABLED, SELECTED
}

sealed class COYAState {
    data class Story(
        val text: String
    ) : COYAState()

    data class Dialogue(
        val text: String,
        val type: DialogType,
        val character: Character,
    ) : COYAState()

    data class Image(
        val imageUrl: String
    ) : COYAState()

    data class StoryActions(
        val defaultActions: List<Action>
    ) : COYAState()
}


sealed class Action(
    open val actionId: String,
    open val text: String,
    open val state: ActionState
) {
    data class DefaultAction(
        override val actionId: String,
        override val text: String,
        override val state: ActionState,
        val nextStoryBranchId: String
    ) : Action(actionId, text, state)

    data class ChanceAction(
        override val actionId: String,
        override val text: String,
        override val state: ActionState,
        val nextStoryBranchIdMap: Map<ClosedFloatingPointRange<Float>, String>
    ) : Action(actionId, text, state)
}


enum class DialogType {
    LEFT, RIGHT
}


data class StoryBranch(
    val storyBranchId: String,
    val list: List<COYAState>
)


sealed class Character(
    val id: String,
    val name: String,
    val avatarIcon: io.github.skeptick.libres.images.Image?, //Todo import resouce
    val photoUrl: String?
) {
    object Player : Character(
        id = "player",
        name = "You",
        avatarIcon = null,
        photoUrl = null
    )

    object Barista : Character(
        id = "barista",
        name = "Barista",
        avatarIcon = null,
        photoUrl = "https://europeancoffeetrip.com/wp-content/uploads/2018/08/LaCabra_Station.jpg"
    )

    object OldMan : Character(
        id = "old_man",
        name = "Old Man",
        avatarIcon = null,
        photoUrl = "https://images.freeimages.com/images/large-previews/7f0/old-man-1561812.jpg"
    )
}