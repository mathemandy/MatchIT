package ng.mathemandy.remote.mappers

interface MatchITRemoteMapper<in REMOTE, out REPOSITORY> {
    fun mapToRepository(remote: REMOTE): REPOSITORY

    fun safeString(value: String?): String = value ?: "N/A"

    fun safeInt(value: Int?): Int = value ?: 0

    fun mapToRepositoryList(value: List<REMOTE>): List<REPOSITORY> = value.map { mapToRepository(it) }
}