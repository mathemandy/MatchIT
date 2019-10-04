package ng.mathemandy.core.base

sealed class BaseState(
    val baseMessage: String
) {
    data class StateLoading(
        val message: String
    ): BaseState(message)

    data class StateFailed(
        val message: String
    ): BaseState(message)

    data class StateSuccessful (
        val message: String
    ): BaseState(message)

    data class StateUpdating (
        val message: String
    ): BaseState(message)

    override fun toString(): String = baseMessage
}