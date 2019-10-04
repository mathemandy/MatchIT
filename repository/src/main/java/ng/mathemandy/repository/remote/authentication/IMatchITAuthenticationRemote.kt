package ng.mathemandy.repository.remote.authentication

import io.reactivex.Single
import ng.mathemandy.repository.models.BaseMatchITRepositoryModel
import ng.mathemandy.repository.models.authentication.MatchITRepositoryUserModel

interface  IMatchITAuthenticationRemote {
    fun  logUserIn(data : HashMap<String, String>) : Single<BaseMatchITRepositoryModel<String>>
    fun getAuthenticatedUser(): Single<BaseMatchITRepositoryModel<MatchITRepositoryUserModel>>
}