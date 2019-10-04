package ng.mathemandy.local.impl.authentication

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.Single
import ng.mathemandy.local.IMatchITPreference
import ng.mathemandy.local.mappers.authentication.MatchITLocalUserModelMapper
import ng.mathemandy.local.room.dao.MatchITUserDao
import ng.mathemandy.repository.local.authentication.IMatchITAuthenticationLocal
import ng.mathemandy.repository.models.authentication.MatchITRepositoryUserModel
import javax.inject.Inject

class MatchITAuthenticationLocalImpl @Inject constructor(
    private val matchITUserDao: MatchITUserDao,
    private val pref: IMatchITPreference,
    private val matchITLocalUserModelMapper: MatchITLocalUserModelMapper
) : IMatchITAuthenticationLocal {

    override fun saveUser(user: MatchITRepositoryUserModel) = matchITUserDao.saveUser(
        matchITLocalUserModelMapper.mapToLocal(user)
    )

    override fun saveUsers(user: List<MatchITRepositoryUserModel>) = matchITUserDao.saveUsers(
        matchITLocalUserModelMapper.mapToLocalList(user)
    )

    override fun getUser(): Observable<List<MatchITRepositoryUserModel>> =
        matchITUserDao.getUser().map { matchITLocalUserModelMapper.mapToRepositoryList(it) }

    override fun getUserFromSharePrefence(): Single<MatchITRepositoryUserModel> {
        val mapType = object : TypeToken<HashMap<String, String>>() {}.type
        val user = Gson().fromJson<HashMap<String, String>>(
           pref.getUserFromPreference(),
            mapType
        )

        return Single.just(user).map {
            MatchITRepositoryUserModel( it["username"]!!,it["email"]!!,  it["id"]!!)
        }
    }
}
