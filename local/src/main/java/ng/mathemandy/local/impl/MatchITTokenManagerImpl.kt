package ng.mathemandy.local.impl

import ng.mathemandy.local.IMatchITPreference
import ng.mathemandy.repository.local.IMatchITTokenManager
import javax.inject.Inject

class MatchITTokenManagerImpl @Inject constructor(
    private val matchITPreference: IMatchITPreference
): IMatchITTokenManager {

    override fun saveToken(token: String) = matchITPreference.saveUserToken(token)

    override fun getToken(): String? = matchITPreference.getUserToken()

    override fun clearPreference() = matchITPreference.clearPreference()
}