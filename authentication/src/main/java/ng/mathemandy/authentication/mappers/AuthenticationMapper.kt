package ng.mathemandy.authentication.mappers

interface AuthenticationMapper <DOMAIN, AUTHENTICATION> {

    fun mapToAuthentication (domain: DOMAIN): AUTHENTICATION

    fun mapToAuthenticationList(domain: List<DOMAIN>): List<AUTHENTICATION> = domain.map { mapToAuthentication(it) }
}