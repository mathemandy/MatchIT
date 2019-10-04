package ng.mathemandy.repository.local.authentication

import io.reactivex.Observable
import io.reactivex.Single
import ng.mathemandy.repository.models.authentication.MatchITRepositoryUserModel

interface IMatchITAuthenticationLocal {

    fun saveUser(user: MatchITRepositoryUserModel)

    fun saveUsers(user: List<MatchITRepositoryUserModel>)

    fun getUser(): Observable<List<MatchITRepositoryUserModel>>

    fun getUserFromSharePrefence() : Single<MatchITRepositoryUserModel>
}