package ng.mathemandy.remote.impl.authentication

import io.reactivex.Single
import ng.mathemandy.remote.mappers.MatchITRemoteUserModelMapper
import ng.mathemandy.remote.services.AuthenticationService
import ng.mathemandy.remote.utils.performActionOnError
import ng.mathemandy.repository.models.BaseMatchITRepositoryModel
import ng.mathemandy.repository.models.authentication.MatchITRepositoryUserModel
import ng.mathemandy.repository.remote.authentication.IMatchITAuthenticationRemote
import retrofit2.Retrofit
import javax.inject.Inject

class AuthenticationRemoteImpl  @Inject constructor(
    retrofit: Retrofit,
    private val userModelMapper : MatchITRemoteUserModelMapper
) : IMatchITAuthenticationRemote  {

    private  val  authenticationService  = retrofit.create(AuthenticationService::class.java)

    override fun logUserIn(data: HashMap<String, String>): Single<BaseMatchITRepositoryModel<String>> = authenticationService.logUserIn(
        data = data
    ).performActionOnError().map {
        BaseMatchITRepositoryModel(
            success = it.success,
            data = it.data?.token,
            message = it.message
        )
    }

    override fun getAuthenticatedUser(): Single<BaseMatchITRepositoryModel<MatchITRepositoryUserModel>> = authenticationService.getAuthenticatedUser().
        performActionOnError().map {
        BaseMatchITRepositoryModel(
            success = it.success,
            data = it.data?.let { remoteUser -> userModelMapper.mapToRepository(remoteUser) },
            message = it.message
        )
    }
}