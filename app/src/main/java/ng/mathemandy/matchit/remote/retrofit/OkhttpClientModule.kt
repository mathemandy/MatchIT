package ng.mathemandy.matchit.remote.retrofit

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import ng.mathemandy.matchit.di.scopes.MatchITAppScope
import ng.mathemandy.matchit.utils.constants.MatchITNetworkConstants
import ng.mathemandy.remote.interceptors.MatchITResponseInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit

@Module (includes = [InterceptorsModule::class])
class OkhttpClientModule {

    @MatchITAppScope @Provides
    internal  fun provideFile(
        context: Context
    ): File =File(context.cacheDir, MatchITNetworkConstants.MATCHIT_OKHTTP_CACHE)

    @MatchITAppScope @Provides
    internal  fun provideCache(
        file: File
    ) : Cache? = Cache(file, 10*1000*1000)


    @MatchITAppScope  @Provides
    internal fun  provideOkhttpClient(
//        httpInterceptor: HttpLoggingInterceptor,
        responseInterceptor: MatchITResponseInterceptor,
        stethoInterceptor: StethoInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder().apply {
//            addInterceptor(httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            addInterceptor(responseInterceptor)
            addNetworkInterceptor(stethoInterceptor)
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)

        }

        return builder.build()
    }
}