package ng.mathemandy.remote.base

data class BaseMatchITRemoteModel<T>(
    val data: T? = null,
    val error: String? = null,
    val message: String,
    val success: Boolean
)