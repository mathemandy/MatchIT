package ng.mathemandy.remote.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONObject
import java.util.*
import javax.inject.Inject

class MatchITResponseInterceptor @Inject constructor(

): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val body = JSONObject(response.body?.string())



        val data : JSONObject?
        data = body

        val newResponse = when (response.code) {
            401 -> {
                val errorMessage = data.getString("error")
                JSONObject().apply {
                    put("success", false)
                    put("message", errorMessage)
                }
            }
            //Handle all other response codes here.
            else -> {
                JSONObject().apply {
                    put("success", true)
                    put("data", data)
                }
            }
        }


        return response.newBuilder().body(
            newResponse.toString().toResponseBody(response.body?.contentType())
        ).build()


    }
}