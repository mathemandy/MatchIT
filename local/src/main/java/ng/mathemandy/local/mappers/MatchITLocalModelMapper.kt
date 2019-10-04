package ng.mathemandy.local.mappers

interface MatchITLocalModelMapper<LOCAL, REPOSITORY> {

    fun mapToLocal(repository: REPOSITORY): LOCAL

    fun mapToRepository(local: LOCAL): REPOSITORY

    fun mapToLocalList(value: List<REPOSITORY>): List<LOCAL> = value.map { mapToLocal(it) }

    fun mapToRepositoryList(value: List<LOCAL>): List<REPOSITORY> =
        value.map { mapToRepository(it) }

    fun safeString(value: String?) = value ?: "N/A"

    fun safeInt(value: Int?) = value ?: 0

    fun safeLocalList(value: List<LOCAL>?): List<LOCAL> = value ?: emptyList()

    fun safeRepositoryList(value: List<REPOSITORY>?): List<REPOSITORY> = value ?: emptyList()
}