package si.vstaric.tuuscasus.game.processor

import si.vstaric.tuuscasus.game.model.Action

class DefaultActionProcessor : ActionProcessor<Action.DefaultAction> {
    override fun invoke(action: Action.DefaultAction): String {
        return action.nextStoryBranchId
    }
}