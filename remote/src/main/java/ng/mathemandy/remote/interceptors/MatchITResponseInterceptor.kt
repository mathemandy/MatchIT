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

        Log.e("Interceptor", body.toString())

        val data : JSONObject?
        data = if(response.code == 201 && response.message.toLowerCase(Locale.getDefault()) == "created"){
            body
        }else {
            body.getJSONObject("data")
        }

        val newResponse = when (response.code) {
            401 -> {
                val errorMessage = data?.getString("message")
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