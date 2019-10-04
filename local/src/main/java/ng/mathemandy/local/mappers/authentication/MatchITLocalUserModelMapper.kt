package ng.mathemandy.local.mappers.authentication

import ng.mathemandy.local.mappers.MatchITLocalModelMapper
import ng.mathemandy.local.models.authentication.MatchITUserLocalModel
import ng.mathemandy.repository.models.authentication.MatchITRepositoryUserModel
import javax.inject.Inject

class MatchITLocalUserModelMapper @Inject constructor(

) : MatchITLocalModelMapper<MatchITUserLocalModel, MatchITRepositoryUserModel> {

    override fun mapToLocal(repository: MatchITRepositoryUserModel): MatchITUserLocalModel =
        MatchITUserLocalModel(
            id = repository.id,
            email = repository.email,
            username = repository.userName
        )

    override fun mapToRepository(local: MatchITUserLocalModel): MatchITRepositoryUserModel =
        MatchITRepositoryUserModel(
            id = local.id,
            userName = safeString(local.username),
            email = safeString(local.email)
        )
}