package ng.mathemandy.preference.impl

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import ng.mathemandy.local.IMatchITPreference
import javax.inject.Inject

class MatchPreferenceImpl @Inject constructor(
    context: Context
): IMatchITPreference {

    private val preference = context.getSharedPreferences(
        MatchITPreferenceConstants.MatchIT_SHARED_PREFERENCE,
        Context.MODE_PRIVATE
    )

    init {
        preference.edit{
            putString(MatchITPreferenceConstants.MatchIT_PREVIOUSLY_LOGGED_IN, Gson().toJson(
                hashMapOf(
                    "username" to "suzan",
                    "email" to "suzan@gmail.com",
                    "id" to "1045"
                )))
        }

    }



    override fun saveUserToken(token: String) {
        preference.edit {
            putString(MatchITPreferenceConstants.MatchIT_USER_TOKEN, token)
        }
    }

    override fun getUserToken(): String? =
        preference.getString(MatchITPreferenceConstants.MatchIT_USER_TOKEN, null)

    override fun clearPreference() = preference.edit { clear() }


    override fun getUserFromPreference(): String? =
        preference.getString(MatchITPreferenceConstants.MatchIT_PREVIOUSLY_LOGGED_IN, null)




}