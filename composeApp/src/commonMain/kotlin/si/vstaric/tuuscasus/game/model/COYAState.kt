package si.vstaric.tuuscasus.game.model

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