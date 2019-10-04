package ng.mathemandy.repository.impl.authentication

import io.reactivex.Observable
import io.reactivex.Single
import ng.mathemandy.domain.models.BaseDomainModel
import ng.mathemandy.domain.models.authentication.MatchITUser
import ng.mathemandy.domain.repository.authentication.IAuthenticationRepository
import ng.mathemandy.repository.local.IMatchITTokenManager
import ng.mathemandy.repository.local.authentication.IMatchITAuthenticationLocal
import ng.mathemandy.repository.mapper.authentication.MatchITUserEntityModelMapper
import ng.mathemandy.repository.models.BaseMatchITRepositoryModel
import ng.mathemandy.repository.remote.authentication.IMatchITAuthenticationRemote
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationRemote: IMatchITAuthenticationRemote,
    private val tokenManager: IMatchITTokenManager,
    private val userEntityModelMapper: MatchITUserEntityModelMapper,
    private val matchITAuthenticationLocal: IMatchITAuthenticationLocal

) : IAuthenticationRepository {

    override fun logUserIn(data: HashMap<String, String>): Single<BaseDomainModel<MatchITUser>> =
        authenticationRemote.logUserIn(
            data = data
        ).map {
            if (it.success) tokenManager.saveToken(it.data!!)
            BaseDomainModel(
                success = it.success,
                data = it.data,
                message = it.message
            )
        }.flatMap {
            if (it.success) authenticationRemote.getAuthenticatedUser()
            else Single.just(
                BaseMatchITRepositoryModel(
                    success = false,
                    message = it.message
                )
            )
        }.map {
            if (it.success) matchITAuthenticationLocal.saveUser(it.data!!)
            BaseDomainModel(
                success = it.success,
                data = it.data?.let { user ->
                    userEntityModelMapper.mapToDomain(user)
                },
                message = it.message
            )
        }

    override fun getLoggedInUser(): Observable<BaseDomainModel<MatchITUser>> =
        matchITAuthenticationLocal.getUser().map {
        if (it.isEmpty()) BaseDomainModel(
            success = false,
            message = "There are no user logged in"
        ) else BaseDomainModel(
            success = true,
            data = userEntityModelMapper.mapToDomain(it[0])
        )
    }

    override fun getUserFromPreference(): Single<BaseDomainModel<MatchITUser>> =
        matchITAuthenticationLocal.getUserFromSharePrefence().map {
            if (it == null) BaseDomainModel(
                success = false,
                message = "There are no user logged in"
            ) else BaseDomainModel(
                success = true,
                data = userEntityModelMapper.mapToDomain(it)
            )

        }


}