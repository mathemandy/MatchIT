package ng.mathemandy.remote.models

data class MatchITRemoteTokenModel (
    val token_type: String,
    val expires_in: String,
    val token: String
)