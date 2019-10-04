package ng.mathemandy.authentication.mappers.authentication

import ng.mathemandy.authentication.mappers.AuthenticationMapper
import ng.mathemandy.authentication.model.MatchITAuthUser
import ng.mathemandy.domain.models.authentication.MatchITUser
import javax.inject.Inject

class MatchITUserModelMapper  @Inject constructor(

) : AuthenticationMapper< MatchITUser, MatchITAuthUser>{
    override fun mapToAuthentication(domain: MatchITUser): MatchITAuthUser {
        return  MatchITAuthUser(
            id = domain.id,
            email = domain.email,
            userName = domain.userName
        )
    }
}