package ng.mathemandy.repository.local

interface IMatchITTokenManager {

    fun saveToken(token: String)

    fun getToken(): String?

    fun clearPreference()
}