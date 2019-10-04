package ng.mathemandy.remote.services

import io.reactivex.Single
import ng.mathemandy.remote.base.BaseMatchITRemoteModel
import ng.mathemandy.remote.models.MatchITRemoteTokenModel
import ng.mathemandy.remote.models.MatchITRemoteUserModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface AuthenticationService {

    @POST("login")
    fun logUserIn(@Body data: HashMap<String, String>): Single<BaseMatchITRemoteModel<MatchITRemoteTokenModel>>

    @GET("user")
    fun getAuthenticatedUser(): Single<BaseMatchITRemoteModel<MatchITRemoteUserModel>>


}