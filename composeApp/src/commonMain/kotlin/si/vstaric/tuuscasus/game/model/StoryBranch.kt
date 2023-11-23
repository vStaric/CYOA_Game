package si.vstaric.tuuscasus.game.model

import si.vstaric.tuuscasus.game.model.COYAState

data class StoryBranch(
    val storyBranchId: String,
    val list: List<COYAState>
)