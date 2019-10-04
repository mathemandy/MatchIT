package ng.mathemandy.domain.repository.authentication

import io.reactivex.Observable
import io.reactivex.Single
import ng.mathemandy.domain.models.BaseDomainModel
import ng.mathemandy.domain.models.authentication.MatchITUser

interface IAuthenticationRepository {

    fun  logUserIn(data : HashMap<String, String>) : Single<BaseDomainModel<MatchITUser>>
    fun getLoggedInUser(): Observable<BaseDomainModel<MatchITUser>>
    fun getUserFromPreference () :  Single<BaseDomainModel<MatchITUser>>

}