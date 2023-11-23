package si.vstaric.tuuscasus.gameRepository

class ValueStore {

    suspend fun saveGame(storyBranchId: String) {
        store.set(storyBranchId)
    }

    suspend fun loadGame(): String {
        return store.get() ?: "start_game"
    }

    suspend fun resetGame() {
        store.reset()
    }
}

