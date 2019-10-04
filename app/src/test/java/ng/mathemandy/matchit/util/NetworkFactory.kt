package ng.mathemandy.matchit.util

import io.reactivex.schedulers.Schedulers
import ng.mathemandy.matchit.BuildConfig
import ng.mathemandy.remote.interceptors.MatchITResponseInterceptor
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkFactory(authInterceptor: MatchITResponseInterceptor) {

    private val okHttpClient: OkHttpClient
    private val retrofitBuilder: Retrofit.Builder

    init {
        val level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(level)

        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

        retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttpClient)
    }

    fun <T> createApi(apiClass: Class<T>, baseUrl: String, interceptors: List<Interceptor> = emptyList()): T {
        if (interceptors.isNotEmpty()) {
            val newClient = okHttpClient.newBuilder()
            interceptors.forEach {
                newClient.addInterceptor(it)
            }
            retrofitBuilder.client(newClient.build())
        }
        return retrofitBuilder.baseUrl(baseUrl).build().create(apiClass)
    }
}