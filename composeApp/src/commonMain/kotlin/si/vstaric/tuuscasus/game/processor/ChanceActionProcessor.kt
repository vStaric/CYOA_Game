package si.vstaric.tuuscasus.game.processor

import si.vstaric.tuuscasus.game.model.Action
import kotlin.random.Random

class ChanceActionProcessor : ActionProcessor<Action.ChanceAction> {
    override fun invoke(action: Action.ChanceAction): String {
        val diceThrow = Random.nextFloat()
        val nextStoryBranchId = action.nextStoryBranchIdMap.entries.firstOrNull {
            diceThrow in it.key
        }?.value
            ?: throw IllegalStateException("No nextStoryBranchId found for diceThrow: $diceThrow")

        return nextStoryBranchId
    }
}