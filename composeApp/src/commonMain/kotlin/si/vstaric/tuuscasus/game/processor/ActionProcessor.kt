package si.vstaric.tuuscasus.game.processor

import si.vstaric.tuuscasus.game.model.Action

interface ActionProcessor<T : Action> {
    operator fun invoke(action: T): String
}