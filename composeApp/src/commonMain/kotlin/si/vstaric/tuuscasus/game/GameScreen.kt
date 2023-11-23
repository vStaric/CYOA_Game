@file:OptIn(ExperimentalMaterial3Api::class)

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.seiko.imageloader.rememberImagePainter
import compose.icons.FeatherIcons
import compose.icons.feathericons.ArrowLeft
import compose.icons.feathericons.Rewind
import org.koin.compose.koinInject
import si.vstaric.tuuscasus.character.CharacterScreen
import si.vstaric.tuuscasus.game.model.Action
import si.vstaric.tuuscasus.game.model.ActionState
import si.vstaric.tuuscasus.game.model.COYAState.Dialogue
import si.vstaric.tuuscasus.game.model.COYAState.Image
import si.vstaric.tuuscasus.game.model.COYAState.Story
import si.vstaric.tuuscasus.game.model.COYAState.StoryActions
import si.vstaric.tuuscasus.game.model.Character
import si.vstaric.tuuscasus.game.model.DialogType
import si.vstaric.tuuscasus.game.model.StoryBranch

object GameScreen : Screen {
    @ExperimentalMaterial3Api
    @Composable
    override fun Content() {
        val viewModel = koinInject<GameViewModel>()

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("This is my game")
                    },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(FeatherIcons.ArrowLeft, null)
                        }
                    }, actions = {
                        IconButton(onClick = { viewModel.goBack() }) {
                            Icon(FeatherIcons.Rewind, null)
                        }
                    })
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues = it)
                ) {
                    GameContent(viewModel)
                }
            }
        )
    }
}

@Composable
private fun GameContent(viewModel: GameViewModel) {
    val storyBranch by viewModel.uiState.collectAsState()
    val navigator = LocalNavigator.currentOrThrow
    StoryBranch(
        storyBranch = storyBranch,
        onActionClick = { viewModel.nextBranch(it) },
        onCharacterClick = { navigator.push(CharacterScreen(it)) }
    )
}

@Composable
private fun StoryBranch(
    storyBranch: StoryBranch,
    onActionClick: (Action) -> Unit,
    onCharacterClick: (Character) -> Unit
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
    onCharacterClick: (Character) -> Unit
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
private fun Character(character: Character, onClick: (Character) -> Unit) {
    Column(
        modifier = Modifier.clickable { onClick(character) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .widthIn(max = 60.dp)
                .aspectRatio(1f),
            painter = rememberImagePainter(character.avatarIcon),
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
fun StoryImage(
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
                ) {
                    Text(text = action.text)
                }
            }
        }
    }
}


