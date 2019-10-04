package ng.mathemandy.navigation

sealed class MatchITIntentKey {

    class  Main : MatchITIntentKey()
    class  Authentication  : MatchITIntentKey()
}