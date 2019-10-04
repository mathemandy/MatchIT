package ng.mathemandy.local


interface IMatchITPreference {

    fun saveUserToken(token: String)

    fun getUserToken(): String?

    fun getUserFromPreference() : String?

    fun clearPreference()
}