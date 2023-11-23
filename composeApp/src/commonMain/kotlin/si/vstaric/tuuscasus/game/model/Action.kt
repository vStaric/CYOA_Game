package si.vstaric.tuuscasus.game.model

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