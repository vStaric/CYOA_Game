package si.vstaric.tuuscasus.title

sealed class TitleUiState {
    object StartGame : TitleUiState()
    object NewGame : TitleUiState()
    object ContinueGame : TitleUiState()
}