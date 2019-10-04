package ng.mathemandy.remote.mappers

import ng.mathemandy.remote.models.MatchITRemoteUserModel
import ng.mathemandy.repository.models.authentication.MatchITRepositoryUserModel
import javax.inject.Inject

class MatchITRemoteUserModelMapper @Inject constructor(
) : MatchITRemoteMapper<MatchITRemoteUserModel, MatchITRepositoryUserModel> {


    override fun mapToRepository(remote: MatchITRemoteUserModel): MatchITRepositoryUserModel {
        return MatchITRepositoryUserModel(
            id = remote.id,
            email = remote.email,
            userName = remote.userName
        )
    }
}