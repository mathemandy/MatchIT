package ng.mathemandy.repository.mapper

interface MatchITRepositoryMapper  <in REPOSITORY, out DOMAIN>{
    fun mapToDomain(repository: REPOSITORY): DOMAIN
    fun mapToDomainList(repositories: List<REPOSITORY>): List<DOMAIN> = repositories.map { mapToDomain(it) }
}