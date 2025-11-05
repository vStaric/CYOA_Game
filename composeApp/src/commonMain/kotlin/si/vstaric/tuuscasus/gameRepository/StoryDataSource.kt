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
                            actionId = "goto_rooftop_garden",
                            text = "Go To The Rooftop Garden",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "goto_rooftop_garden"
                        ),
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
                            text = "Try Again",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "rps_start"
                        ),
                        Action.DefaultAction(
                            actionId = "explore_cave_deeper",
                            text = "Ignore Him and Explore Deeper",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "explore_cave_deeper"
                        )
                    )
                )
            )
        )

        // NEW CONTENT: Rooftop Garden Path
        val RooftopGardenEntrance = StoryBranch(
            storyBranchId = "goto_rooftop_garden",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.unsplash.com/photo-1585320806297-9794b3e4eeae"),
                COYAState.Story(
                    text = "Following the barista's directions, I climbed a narrow staircase hidden between two buildings. The sounds of the city faded as I ascended, replaced by the gentle rustling of leaves and distant birdsong."
                ),
                COYAState.Story(
                    text = "At the top, I pushed open a weathered door and stepped into an unexpected paradise. The rooftop garden sprawled before me—a tapestry of green amid the concrete jungle. Flowers of every color bloomed in carefully tended beds, and vines cascaded down trellises."
                ),
                COYAState.Image(imageUrl = "https://images.unsplash.com/photo-1588417865884-b074fe2f7b85"),
                COYAState.Story(
                    text = "In the center of the garden, an elderly woman knelt beside a bed of roses, her weathered hands working the soil with practiced care. She looked up as I approached, her eyes twinkling with kindness."
                ),
                COYAState.Dialogue(
                    text = "Ah, a new visitor! The barista sent you, didn't they? Welcome to my sanctuary.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.GardenKeeper
                ),
                COYAState.Dialogue(
                    text = "This place is incredible. How long have you been maintaining this garden?",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.Dialogue(
                    text = "Nearly forty years now. This garden has been my teacher, my friend, and my refuge. Every plant here has a story, and every story has a lesson.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.GardenKeeper
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "ask_about_garden",
                            text = "Ask About The Garden",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "ask_about_garden"
                        ),
                        Action.DefaultAction(
                            actionId = "explore_garden",
                            text = "Explore The Garden",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "explore_garden"
                        )
                    )
                )
            )
        )

        val AskAboutGarden = StoryBranch(
            storyBranchId = "ask_about_garden",
            list = listOf(
                COYAState.Dialogue(
                    text = "Tell me about this place. What makes it so special?",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.Dialogue(
                    text = "This garden represents the balance between chaos and order, growth and decay. In the city below, people rush through life, never pausing to breathe. Here, time moves differently.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.GardenKeeper
                ),
                COYAState.Dialogue(
                    text = "Each plant teaches patience. The roses remind us that beauty requires care and sometimes enduring thorns. The bamboo shows us strength through flexibility.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.GardenKeeper
                ),
                COYAState.Story(
                    text = "She stood up slowly, brushing soil from her knees, and gestured to a secluded corner of the garden where a small meditation area sat beneath a blooming wisteria."
                ),
                COYAState.Dialogue(
                    text = "Would you like to sit for a while? Sometimes the garden speaks to those who listen.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.GardenKeeper
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "meditate_in_garden",
                            text = "Sit and Meditate",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "meditate_in_garden"
                        ),
                        Action.DefaultAction(
                            actionId = "decline_meditation",
                            text = "Decline and Return to the City",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "wander_the_streets"
                        )
                    )
                )
            )
        )

        val ExploreGarden = StoryBranch(
            storyBranchId = "explore_garden",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.unsplash.com/photo-1466692476868-aef1dfb1e735"),
                COYAState.Story(
                    text = "I wandered through the garden paths, discovering hidden corners and unexpected delights. A small fountain burbled peacefully, surrounded by smooth stones. Butterflies danced among the lavender."
                ),
                COYAState.Story(
                    text = "In one corner, I noticed something peculiar—a section where the plants grew in an unusual pattern, almost like a labyrinth. At its center, a single white lily bloomed, pristine and luminous."
                ),
                COYAState.Story(
                    text = "As I reached for the flower, the Garden Keeper's voice called out."
                ),
                COYAState.Dialogue(
                    text = "Ah, you found the Heart of the Garden. Many visitors walk past it, but you were drawn to it. That flower only blooms for those seeking something more than just beauty.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.GardenKeeper
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "meditate_in_garden",
                            text = "Sit Near The Lily",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "meditate_in_garden"
                        ),
                        Action.DefaultAction(
                            actionId = "ask_about_garden",
                            text = "Ask About The Garden",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "ask_about_garden"
                        )
                    )
                )
            )
        )

        val MeditateInGarden = StoryBranch(
            storyBranchId = "meditate_in_garden",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.unsplash.com/photo-1499209974431-9dddcece7f88"),
                COYAState.Story(
                    text = "I settled onto the cushion beneath the wisteria, closing my eyes and breathing in the fragrant air. The sounds of the city below became a distant hum, like the ocean heard from far away."
                ),
                COYAState.Story(
                    text = "Minutes passed, or perhaps hours—time seemed to lose its meaning. In the stillness, I felt something shift within me. The constant chatter of my mind quieted, replaced by a profound sense of peace."
                ),
                COYAState.Story(
                    text = "When I finally opened my eyes, the garden seemed somehow different—more vibrant, more alive. The Garden Keeper sat nearby, smiling knowingly."
                ),
                COYAState.Dialogue(
                    text = "You've found it, haven't you? The silence between thoughts. The space where true understanding grows.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.GardenKeeper
                ),
                COYAState.Dialogue(
                    text = "I feel... different. Lighter, somehow. Like I've been carrying something heavy and just set it down.",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.Dialogue(
                    text = "That's the gift of the garden. You can return to the world below now, but you'll carry this peace with you. Or... you could stay and learn more. The choice is yours.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.GardenKeeper
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "ending_enlightenment",
                            text = "Stay and Learn From The Garden",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "ending_enlightenment"
                        ),
                        Action.DefaultAction(
                            actionId = "ending_return_peaceful",
                            text = "Return to The City With New Wisdom",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "ending_return_peaceful"
                        )
                    )
                )
            )
        )

        // NEW CONTENT: Cave Exploration Path
        val ExploreCaveDeeper = StoryBranch(
            storyBranchId = "explore_cave_deeper",
            list = listOf(
                COYAState.Story(
                    text = "Ignoring the old man's cryptic words, I turned away from him and ventured deeper into the cavern. The glowing walls pulsed with an otherworldly light, casting dancing shadows on the stone."
                ),
                COYAState.Image(imageUrl = "https://images.unsplash.com/photo-1544551763-46a013bb70d5"),
                COYAState.Story(
                    text = "The passage narrowed, then opened into a vast underground chamber. Stalactites hung from the ceiling like teeth, and in the center of the chamber, a pool of crystal-clear water reflected the luminescent ceiling like a mirror."
                ),
                COYAState.Story(
                    text = "As I approached the pool, the water began to ripple, though there was no wind. A form emerged from its depths—not quite solid, not quite liquid, but something in between. It coalesced into a vaguely humanoid shape, glowing with soft blue light."
                ),
                COYAState.Dialogue(
                    text = "A visitor from the world above. It has been long since one ventured this deep.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.CaveSpirit
                ),
                COYAState.Dialogue(
                    text = "What... what are you?",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.Dialogue(
                    text = "I am memory. I am possibility. I am the echo of what was and the whisper of what could be. This cave exists between moments, between choices.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.CaveSpirit
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "ask_cave_spirit",
                            text = "Ask How To Leave",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "ask_cave_spirit"
                        ),
                        Action.DefaultAction(
                            actionId = "touch_the_pool",
                            text = "Touch The Pool",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "touch_the_pool"
                        )
                    )
                )
            )
        )

        val AskCaveSpirit = StoryBranch(
            storyBranchId = "ask_cave_spirit",
            list = listOf(
                COYAState.Dialogue(
                    text = "How do I get out of here? How do I return to my world?",
                    type = DialogType.RIGHT,
                    character = si.vstaric.tuuscasus.game.model.Character.Player
                ),
                COYAState.Dialogue(
                    text = "Return? But you are already where you need to be. Every path you've walked, every choice you've made, led you here.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.CaveSpirit
                ),
                COYAState.Dialogue(
                    text = "The old man offers you repetition—the same choice, the same game, forever. I offer you transformation. Look into the pool, and see what you could become.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.CaveSpirit
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "look_into_pool",
                            text = "Look Into The Pool",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "look_into_pool"
                        ),
                        Action.DefaultAction(
                            actionId = "refuse_spirit",
                            text = "Refuse and Return to The Old Man",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "rps_start"
                        )
                    )
                )
            )
        )

        val TouchThePool = StoryBranch(
            storyBranchId = "touch_the_pool",
            list = listOf(
                COYAState.Story(
                    text = "Without thinking, I reached out and touched the surface of the pool. The water was neither warm nor cold—it felt like touching liquid starlight."
                ),
                COYAState.Story(
                    text = "Ripples spread from my fingertips, and suddenly I saw images in the water—countless versions of myself, living countless different lives. In one, I stayed in the café and became friends with the barista. In another, I never entered the park. In yet another, I'm standing exactly where I am now, but making a different choice."
                ),
                COYAState.Dialogue(
                    text = "You see it now, don't you? The infinite branches of possibility. Each choice creates a new world, a new you.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.CaveSpirit
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "look_into_pool",
                            text = "Look Deeper Into The Pool",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "look_into_pool"
                        )
                    )
                )
            )
        )

        val LookIntoPool = StoryBranch(
            storyBranchId = "look_into_pool",
            list = listOf(
                COYAState.Story(
                    text = "I gazed deeper into the pool's surface, and the images intensified. I saw myself wandering the city streets, but with purpose now. I saw myself in the rooftop garden, learning from the Garden Keeper. I saw myself helping others find their own paths."
                ),
                COYAState.Dialogue(
                    text = "You understand now. This cave is not a prison—it's a crossroads. A place where you can choose to transform.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.CaveSpirit
                ),
                COYAState.Dialogue(
                    text = "I can offer you two paths. One returns you to the surface, but you will remember this encounter. You'll carry the knowledge of possibility with you. The other... keeps you here, in this space between choices, where you can observe all paths without walking any.",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.CaveSpirit
                ),
                COYAState.Dialogue(
                    text = "Which will you choose?",
                    type = DialogType.LEFT,
                    character = si.vstaric.tuuscasus.game.model.Character.CaveSpirit
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "ending_freedom",
                            text = "Return to The Surface",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "ending_freedom"
                        ),
                        Action.DefaultAction(
                            actionId = "ending_observer",
                            text = "Stay and Become An Observer",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "ending_observer"
                        )
                    )
                )
            )
        )

        // NEW CONTENT: Multiple Endings
        val EndingEnlightenment = StoryBranch(
            storyBranchId = "ending_enlightenment",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.unsplash.com/photo-1518709268805-4e9042af9f23"),
                COYAState.Story(
                    text = "I chose to stay. Days turned into weeks, weeks into months. The Garden Keeper taught me the language of plants, the rhythm of seasons, the patience of growth."
                ),
                COYAState.Story(
                    text = "The city below continued its frantic pace, but I found peace in the slow unfurling of leaves, the gradual opening of buds. I learned that true adventure isn't always about movement—sometimes it's about stillness, about being present in each moment."
                ),
                COYAState.Story(
                    text = "Years later, when the Garden Keeper's time came to rest, I took up her role. Now I tend these plants, and occasionally, someone climbs those stairs, seeking something they can't quite name."
                ),
                COYAState.Story(
                    text = "And I smile, just as she once smiled at me, welcoming them to the sanctuary."
                ),
                COYAState.Story(
                    text = "THE END - The Garden Keeper's Legacy"
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "start_game",
                            text = "Begin A New Story",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "start_game"
                        )
                    )
                )
            )
        )

        val EndingReturnPeaceful = StoryBranch(
            storyBranchId = "ending_return_peaceful",
            list = listOf(
                COYAState.Image(imageUrl = "https://images.unsplash.com/photo-1477959858617-67f85cf4f1df"),
                COYAState.Story(
                    text = "I thanked the Garden Keeper and descended back to the city streets. But something had changed. The noise didn't overwhelm me anymore. The crowds didn't feel suffocating."
                ),
                COYAState.Story(
                    text = "I carried the garden's peace within me, a quiet center that remained calm no matter what swirled around it. People noticed the change—strangers smiled at me more, as if sensing a tranquility they wanted to be near."
                ),
                COYAState.Story(
                    text = "I returned to my regular life, but it wasn't regular anymore. Every moment held possibility. Every encounter was an opportunity for connection. I had learned the secret: adventure doesn't require exotic locations—it blooms wherever we choose to be fully present."
                ),
                COYAState.Story(
                    text = "And sometimes, on difficult days, I would climb those stairs again, sit beneath the wisteria, and remember who I really was."
                ),
                COYAState.Story(
                    text = "THE END - The Peaceful Return"
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "start_game",
                            text = "Begin A New Story",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "start_game"
                        )
                    )
                )
            )
        )

        val EndingFreedom = StoryBranch(
            storyBranchId = "ending_freedom",
            list = listOf(
                COYAState.Story(
                    text = "The Cave Spirit's form shimmered, and the pool's surface became like glass. I stepped onto it, and instead of falling through, I walked across it as if it were solid ground."
                ),
                COYAState.Story(
                    text = "With each step, the cavern around me faded. The glowing walls dimmed, the old man's presence vanished, and I found myself rising, floating upward through layers of earth and stone."
                ),
                COYAState.Image(imageUrl = "https://images.unsplash.com/photo-1506905925346-21bda4d32df4"),
                COYAState.Story(
                    text = "I emerged not in the park where I fell, but on a hilltop overlooking the entire city. The sun was setting, painting the sky in shades of orange and purple. But I saw it differently now—I saw all the paths not taken, all the possibilities still waiting."
                ),
                COYAState.Story(
                    text = "I understood that every moment was a choice, every choice a new world. The cave hadn't trapped me—it had freed me to see that I was never trapped at all. Every day is a new adventure, and every adventure is a choice to live fully."
                ),
                COYAState.Story(
                    text = "I walked down the hill toward the city lights, ready to explore with new eyes, carrying the knowledge that infinite possibilities lay in every direction."
                ),
                COYAState.Story(
                    text = "THE END - The Freedom of Choice"
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "start_game",
                            text = "Begin A New Story",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "start_game"
                        )
                    )
                )
            )
        )

        val EndingObserver = StoryBranch(
            storyBranchId = "ending_observer",
            list = listOf(
                COYAState.Story(
                    text = "I chose to stay, to become like the Cave Spirit—existing between moments, observing the infinite branches of reality without walking any single path."
                ),
                COYAState.Story(
                    text = "My form slowly dissolved, becoming one with the pool, with the cave, with the space between choices. I could see everything now—every person in the city above, every decision they faced, every path they might take."
                ),
                COYAState.Story(
                    text = "I watched myself in other timelines: becoming a barista's friend, a garden keeper's student, an old man's eternal opponent. I watched others fall into the cave as I had, and I whispered to them as the Cave Spirit once whispered to me."
                ),
                COYAState.Story(
                    text = "Time lost all meaning. I was everywhere and nowhere, everyone and no one. I had become the crossroads itself, the moment of possibility, the breath before a choice is made."
                ),
                COYAState.Story(
                    text = "And in that eternal moment, I understood: every story is happening simultaneously, every ending is also a beginning, and in the space between, all things are possible."
                ),
                COYAState.Story(
                    text = "THE END - The Observer Between Worlds"
                ),
                COYAState.StoryActions(
                    defaultActions = listOf(
                        Action.DefaultAction(
                            actionId = "start_game",
                            text = "Begin A New Story",
                            state = ActionState.ENABLED,
                            nextStoryBranchId = "start_game"
                        )
                    )
                )
            )
        )

        return mapOf(
            // Original Story Branches
            "start_game" to Start,
            "wander_the_streets" to InTheStreets,
            "grab_a_coffee" to grabACoffee,
            "goto_the_park" to InThePark,
            "explore_the_park" to ExploreThePark,
            "look_into_the_abyss" to InTheAbyss,

            // Rock Paper Scissors Game
            "rps_start" to RockPaperScissors_Start,
            "rps_success_scissors" to RockPaperScissors_SuccessScissors,
            "rps_success_rock" to RockPaperScissors_SuccessRock,
            "rps_success_paper" to RockPaperScissors_SuccessPaper,
            "rps_draw" to RockPaperScissors_Draw,
            "rps_fail" to RockPaperScissors_Fail,

            // Rooftop Garden Path
            "goto_rooftop_garden" to RooftopGardenEntrance,
            "ask_about_garden" to AskAboutGarden,
            "explore_garden" to ExploreGarden,
            "meditate_in_garden" to MeditateInGarden,

            // Cave Exploration Path
            "explore_cave_deeper" to ExploreCaveDeeper,
            "ask_cave_spirit" to AskCaveSpirit,
            "touch_the_pool" to TouchThePool,
            "look_into_pool" to LookIntoPool,

            // Multiple Endings
            "ending_enlightenment" to EndingEnlightenment,
            "ending_return_peaceful" to EndingReturnPeaceful,
            "ending_freedom" to EndingFreedom,
            "ending_observer" to EndingObserver,
        )
    }
}