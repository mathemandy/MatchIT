package ng.mathemandy.repository.mapper.authentication

import ng.mathemandy.domain.models.authentication.MatchITUser
import ng.mathemandy.repository.mapper.MatchITRepositoryMapper
import ng.mathemandy.repository.models.authentication.MatchITRepositoryUserModel
import javax.inject.Inject

class MatchITUserEntityModelMapper  @Inject  constructor(


) : MatchITRepositoryMapper<MatchITRepositoryUserModel, MatchITUser> {

    override fun mapToDomain(repository: MatchITRepositoryUserModel): MatchITUser {
        return  MatchITUser(
            id = repository.id,
            userName = repository.userName,
            email = repository.email
        )
    }
}