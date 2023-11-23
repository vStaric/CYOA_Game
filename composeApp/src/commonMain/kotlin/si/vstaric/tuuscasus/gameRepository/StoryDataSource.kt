package si.vstaric.tuuscasus.gameRepository

import si.vstaric.tuuscasus.game.model.Action
import si.vstaric.tuuscasus.game.model.ActionState
import si.vstaric.tuuscasus.game.model.COYAState
import si.vstaric.tuuscasus.game.model.DialogType
import si.vstaric.tuuscasus.game.model.StoryBranch

class StoryDataSource {
    fun createStory(): Map<String, StoryBranch> {
        val Start = StoryBranch(
            storyBranchId = "start_game",
            list = listOf(
                COYAState.Image(imageUrl = "https://img.freepik.com/premium-photo/european-street-serenity-daylight-journey-through-historic-cobblestone-roads_720722-19290.jpg"),
                COYAState.Story(
                    text = "The day had started like any other. The sun beamed down from a cloudless sky as I stepped out of my apartment, the warmth of the morning inviting me to explore the city. With no particular plans, I decided to take a leisurely stroll through the neighborhood."
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "wander_the_streets",
                            text = "Wander The Streets",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "wander_the_streets"
                        ),
                        Action.DefaultAction(
                            actionId = "goto_the_park",
                            text = "Go To The Park",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "goto_the_park"
                        )
                    )
                )
            )
        )

        val InTheStreets = StoryBranch(
            storyBranchId = "wander_the_streets",
            list = listOf(
                COYAState.Image(imageUrl = "https://img.freepik.com/premium-photo/autumn-leaves-illuminate-old-building-facade-dusk-generated-by-ai_24640-89035.jpg?size=626&ext=jpg&ga=GA1.1.1826414947.1698883200&semt=ais"),
                COYAState.Story(
                    text = "As I wandered down familiar streets, the rhythm of life unfolded around me. People hustled and bustled, each lost in their own world. The city seemed alive with energy, and I felt a sense of belonging amid the urban symphony."
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "grab_a_coffee",
                            text = "Grab A Coffee",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "grab_a_coffee"
                        ),
                        Action.DefaultAction(
                            actionId = "goto_the_park",
                            text = "Go To The Park",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "goto_the_park"
                        )
                    )
                )
            )
        )

        val grabACoffee = StoryBranch(
            storyBranchId = "grab_a_coffee",
            list = listOf(
                COYAState.Image(imageUrl = "https://thetravelquandary.com/wp-content/uploads/2020/02/40-Cafes-For-The-Best-Coffee-in-Europe_16_L.jpg"),
                COYAState.Story(
                    text = "The aroma of freshly brewed coffee drew me into a cozy little café tucked between the bustling buildings. The bell above the door tinkled softly as I stepped inside, the warm scent enveloping me like a comforting embrace. I approached the counter, where a barista with a friendly smile greeted me.",
                ),
                COYAState.Image(imageUrl = "https://europeancoffeetrip.com/wp-content/uploads/2018/08/LaCabra_Station.jpg"),
                COYAState.Dialogue(
                    text = "Good afternoon! What can I get for you today?",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.Barista
                ),
                COYAState.Dialogue(
                    text = "Hi there! A cappuccino, please. And, um, make it with an extra shot of adventure.",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.Dialogue(
                    text = "An adventurous cappuccino it is! Anything else?",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.Barista
                ),
                COYAState.Dialogue(
                    text = "Just a dash of inspiration, if you have it handy.",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.Dialogue(
                    text = "I'll see what I can do. Coming right up.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.Barista
                ),
                COYAState.Story(
                    text = "The barista prepares the order."
                ),
                COYAState.Dialogue(
                    text = "Just wandering the streets, you know? Sometimes the best stories unfold when you least expect them.",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.Dialogue(
                    text = "Life's full of unexpected twists. Here's your cappuccino, with an extra shot of adventure and a dash of inspiration.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.Barista
                ),
                COYAState.Dialogue(
                    text = "Perfect, just what I needed. Thanks! By the way, what's your favorite adventure in the city?",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.Dialogue(
                    text = "There's this hidden rooftop garden not far from here. It's my sanctuary in the midst of the urban chaos. You should check it out sometime.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.Barista
                ),
                COYAState.Dialogue(
                    text = "Sounds amazing. I'll make it my next stop. Thanks for the tip!",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "wander_the_streets",
                            text = "Wander The Streets",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "wander_the_streets"
                        )
                    )
                )
            )
        )

        val InThePark = StoryBranch(
            storyBranchId = "goto_the_park",
            list = listOf(
                COYAState.Image(imageUrl = "https://thumbs.dreamstime.com/b/romantic-landscape-bench-mestni-city-park-maribor-slovenia-lower-styria-europe-nature-green-trees-blooming-spring-166529530.jpg"),
                COYAState.Story(
                    text = "Turning a corner, I noticed a peculiar sight—a small park I hadn't explored before. Intrigued, I ventured in, the crunch of gravel beneath my shoes the only sound breaking the peaceful atmosphere. The park was a hidden gem, with vibrant flowers and a well-worn path that wound through the greenery."
                ),
                COYAState.StoryActions(
                    listOf(
                        Action.DefaultAction(
                            actionId = "explore_the_park",
                            text = "Explore The Park",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "explore_the_park"
                        ),
                        Action.DefaultAction(
                            actionId = "wander_the_streets",
                            text = "Wander The Streets",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "wander_the_streets"
                        ),
                    )
                )
            )
        )

        val ExploreThePark = StoryBranch(
            storyBranchId = "explore_the_park",
            list = listOf(
                COYAState.Image(imageUrl = "https://theecologist.org/sites/default/files/styles/inline_l/public/NG_media/405032.jpg?itok=HKf62wbO"),
                COYAState.Story(
                    text = "In the heart of the park, I discovered an old oak tree, its branches stretching skyward. Nestled at its base was a peculiar hole, a dark portal into the unknown. My curiosity got the better of me, and without a second thought, I peered into the abyss."
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "look_into_the_abyss",
                            text = "Look in to the Abyss",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "look_into_the_abyss"
                        ),
                        Action.DefaultAction(
                            actionId = "go_back_to_park",
                            text = "Go Back To The Park",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "goto_the_park"
                        )
                    )
                )
            )
        )

        val InTheAbyss = StoryBranch(
            storyBranchId = "look_into_the_abyss",
            list = listOf(
                COYAState.Image(imageUrl = "https://img.atlasobscura.com/vc-Zo60cT3hYK5FzESLk4HSOLAmJ5QeuRt2R02w9ZEg/rs:fill:12000:12000/q:81/sm:1/scp:1/ar:1/aHR0cHM6Ly9hdGxh/cy1kZXYuczMuYW1h/em9uYXdzLmNvbS91/cGxvYWRzL2Fzc2V0/cy9kZTViNWJkOS0y/N2RiLTRiNTctYWE1/Mi02OThmZGQyOGYy/MTIyODcyMDZmYzUz/MzgwZjFlOTRfODAw/cHgtS3ZpbGxla2Vu/XzIwMTJkLmpwZw.jpg"),
                COYAState.Story(
                    text = "As I leaned in for a closer look, the ground beneath me crumbled, and before I could react, I found myself tumbling headfirst down the hole. The world blurred around me, and I felt a mix of excitement and trepidation as I descended into the unknown."
                ),
                COYAState.Story(
                    text = "Moments later, I landed with a soft thud on a bed of moss at the bottom of the hole. The air was cool and damp, and a soft glow emanated from the walls of the cavern that surrounded me. I stood up, brushing dirt off my clothes, and took in my surreal surroundings."
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "start_game",
                            text = "END of the game",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "start_game"
                        ),
                        Action.DefaultAction(
                            actionId = "rps_start",
                            text = "There is an old man in the cave",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "rps_start"
                        )
                    )
                )
            )
        )

        val RockPaperScissors_Start = StoryBranch(
            storyBranchId = "rps_start",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.freeimages.com/images/large-previews/7f0/old-man-1561812.jpg"),
                COYAState.Dialogue(
                    text = "Beat me at rock paper scissors and I'll return you to your past life.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.OldMan
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.ChanceAction(
                            actionId = "rps_rock",
                            text = "Rock",
                            state = ActionState.ENABLED,
                            nextStoryBranchIdMap = mapOf(
                                0.0f..0.33f to "rps_success_scissors",
                                0.34f..0.66f to "rps_draw",
                                0.67f..1.0f to "rps_fail"
                            )
                        ),
                        Action.ChanceAction(
                            actionId = "rps_paper",
                            text = "Paper",
                            state = ActionState.ENABLED,
                            nextStoryBranchIdMap = mapOf(
                                0.0f..0.33f to "rps_success_rock",
                                0.34f..0.66f to "rps_draw",
                                0.67f..1.0f to "rps_fail"
                            )
                        ),
                        Action.ChanceAction(
                            actionId = "rps_scissors",
                            text = "Scissors",
                            state = ActionState.ENABLED,
                            nextStoryBranchIdMap = mapOf(
                                0.0f..0.33f to "rps_success_paper",
                                0.34f..0.66f to "rps_draw",
                                0.67f..1.0f to "rps_fail"
                            )
                        )
                    )
                )
            )
        )


        val RockPaperScissors_SuccessScissors = StoryBranch(
            storyBranchId = "rps_success_scissors",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.freeimages.com/images/large-previews/7f0/old-man-1561812.jpg"),
                COYAState.Dialogue(
                    text = "Rock beats scissors. You won! I'll return you to your past life.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.OldMan
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "start_game",
                            text = "Wake up!",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "start_game"
                        )
                    )
                )
            )
        )

        val RockPaperScissors_SuccessRock = StoryBranch(
            storyBranchId = "rps_success_rock",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.freeimages.com/images/large-previews/7f0/old-man-1561812.jpg"),
                COYAState.Dialogue(
                    text = "Paper beats rock. You won! I'll return you to your past life.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.OldMan
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "start_game",
                            text = "Wake up!",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "start_game"
                        )
                    )
                )
            )
        )

        val RockPaperScissors_SuccessPaper = StoryBranch(
            storyBranchId = "rps_success_paper",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.freeimages.com/images/large-previews/7f0/old-man-1561812.jpg"),
                COYAState.Dialogue(
                    text = "Scissors beats paper. You won! I'll return you to your past life.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.OldMan
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "start_game",
                            text = "Wake up!",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "start_game"
                        )
                    )
                )
            )
        )

        val RockPaperScissors_Draw = StoryBranch(
            storyBranchId = "rps_draw",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.freeimages.com/images/large-previews/7f0/old-man-1561812.jpg"),
                COYAState.Dialogue(
                    text = "A draw. Let's play again.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.OldMan
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "rps_start",
                            text = "Play again",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "rps_start"
                        )
                    )
                )
            )
        )

        val RockPaperScissors_Fail = StoryBranch(
            storyBranchId = "rps_fail",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.freeimages.com/images/large-previews/7f0/old-man-1561812.jpg"),
                COYAState.Dialogue(
                    text = "Come closer. I'll tell you a secret. You can't win.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.OldMan
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "rps_start",
                            text = "Wake Up!",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "rps_start"
                        )
                    )
                )
            )
        )

        return mapOf(
            "start_game" to Start,
            "wander_the_streets" to InTheStreets,
            "grab_a_coffee" to grabACoffee,
            "goto_the_park" to InThePark,
            "explore_the_park" to ExploreThePark,
            "look_into_the_abyss" to InTheAbyss,
            "rps_start" to RockPaperScissors_Start,
            "rps_success_scissors" to RockPaperScissors_SuccessScissors,
            "rps_success_rock" to RockPaperScissors_SuccessRock,
            "rps_success_paper" to RockPaperScissors_SuccessPaper,
            "rps_draw" to RockPaperScissors_Draw,
            "rps_fail" to RockPaperScissors_Fail,
        )
    }
}