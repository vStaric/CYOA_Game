package si.vstaric.tuuscasus.gameRepository

import si.vstaric.tuuscasus.game.model.StoryBranch

class GameRepository(
    storyDataSource: StoryDataSource,
    private val valueStore: ValueStore
) {

    private val inMemoryStory: Map<String, StoryBranch> = storyDataSource.createStory()

    fun getStoryByBranchId(branchId: String) = inMemoryStory[branchId]
        ?: throw IllegalStateException("No storyBranch found for nextBranchId: $branchId")

    suspend fun storeStoryBranchId(storyBranchId: String) {
        valueStore.saveGame(storyBranchId)
    }

    suspend fun loadStoryBranchId(): String {
        return valueStore.loadGame()
    }

    suspend fun resetGame() {
        valueStore.resetGame()
    }
}

