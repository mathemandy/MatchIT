package ng.mathemandy.domain.interactors.authentication

import io.reactivex.Observable
import ng.mathemandy.domain.models.BaseDomainModel
import ng.mathemandy.domain.models.authentication.MatchITUser
import ng.mathemandy.domain.repository.authentication.IAuthenticationRepository
import ng.mathemandy.domain.utils.RxObservationThread
import ng.mathemandy.domain.interactors.ObservableUseCase
import javax.inject.Inject

class GetUserLoggedIn  @Inject constructor(
    observationThread: RxObservationThread,
    private val authenticationRepository : IAuthenticationRepository
) : ObservableUseCase<Nothing, BaseDomainModel<MatchITUser>>(observationThread){

    override fun buildUseCaseObservable(param: Nothing?): Observable<BaseDomainModel<MatchITUser>>  = authenticationRepository.getLoggedInUser()
}