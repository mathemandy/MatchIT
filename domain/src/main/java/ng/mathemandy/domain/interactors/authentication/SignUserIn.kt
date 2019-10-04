package ng.mathemandy.domain.interactors.authentication

import io.reactivex.Single
import ng.mathemandy.domain.models.BaseDomainModel
import ng.mathemandy.domain.models.authentication.MatchITUser
import ng.mathemandy.domain.repository.authentication.IAuthenticationRepository
import ng.mathemandy.domain.utils.RxObservationThread
import ng.mathemandy.domain.interactors.SingleUseCase
import javax.inject.Inject

class SignUserIn @Inject constructor(
    observationThread: RxObservationThread,
    private val authenticationRepository: IAuthenticationRepository

): SingleUseCase<SignUserIn.SignInParameters, BaseDomainModel<MatchITUser>>(observationThread) {

    override fun buildUseCaseSingle(param: SignInParameters?): Single<BaseDomainModel<MatchITUser>> = param?.let {
        authenticationRepository.logUserIn(
            hashMapOf(
                "email" to it.email,
                "password" to it.password
            )
        )
    } ?: throw IllegalArgumentException("Login parameters cannot be empty!")

    data class SignInParameters (
        val email: String,
        val password: String
    ) {
        companion object {
            @JvmStatic
            fun make (
                email: String,
                password: String
            ): SignInParameters = SignInParameters(
                email = email,
                password = password
            )
        }
    }
}