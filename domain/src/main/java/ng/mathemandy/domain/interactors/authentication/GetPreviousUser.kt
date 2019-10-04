package ng.mathemandy.domain.interactors.authentication

import io.reactivex.Single
import ng.mathemandy.domain.interactors.SingleUseCase
import ng.mathemandy.domain.models.BaseDomainModel
import ng.mathemandy.domain.models.authentication.MatchITUser
import ng.mathemandy.domain.repository.authentication.IAuthenticationRepository
import ng.mathemandy.domain.utils.RxObservationThread
import javax.inject.Inject


class  GetPreviousUser @Inject constructor(
    observationThread: RxObservationThread,
    private val authenticationRepository: IAuthenticationRepository
) : SingleUseCase<Nothing, BaseDomainModel<MatchITUser>>(observationThread) {


    override fun buildUseCaseSingle(param: Nothing?): Single<BaseDomainModel<MatchITUser>> =
        authenticationRepository.getUserFromPreference()
}