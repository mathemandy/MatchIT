package ng.mathemandy.remote.utils

import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.*

object MatchITRemoteExceptionHandler {

    fun getErrorFromThrowable(throwable: Throwable): String {
        return when (throwable) {
            is ConnectException -> MatchITRemoteConstants.CONNECT_EXCEPTION
            is UnknownHostException -> MatchITRemoteConstants.UNKNOWN_HOST_EXCEPTION
            is SocketTimeoutException -> MatchITRemoteConstants.SOCKET_TIME_OUT_EXCEPTION
            is UnknownServiceException -> throwable.localizedMessage
            is ProtocolException -> MatchITRemoteConstants.PROTOCOL_EXCEPTION
            is HttpException -> {
                return if (throwable.code() == 401) {
                    return  MatchITRemoteConstants.INVVALID_PASSWORD
                } else if (throwable.code() == 500){
                    return  MatchITRemoteConstants.INTERNEAL_SUMMARY_ISSUE
                }
                else try {
                    val response = throwable.response()
                    val json = JSONObject(response.errorBody()?.string())
                    json.getString("message")
                } catch (e1: JSONException) {
                    MatchITRemoteConstants.UNKNOWN_NETWORK_EXCEPTION
                } catch (e1: IOException) {
                    MatchITRemoteConstants.UNKNOWN_NETWORK_EXCEPTION
                }
            }
            else -> MatchITRemoteConstants.UNKNOWN_NETWORK_EXCEPTION
        }
    }
}