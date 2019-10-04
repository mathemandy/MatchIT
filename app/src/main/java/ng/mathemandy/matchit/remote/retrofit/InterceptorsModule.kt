package ng.mathemandy.matchit.remote.retrofit

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import ng.mathemandy.matchit.di.scopes.MatchITAppScope


@Module
class InterceptorsModule {

//    @Provides @MatchITAppScope
//    internal fun provideNetworkInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger{
//        message -> MatchITLog.e(message)
//    }).setLevel(
//        HttpLoggingInterceptor.Level.BODY
//    )
//

    @Provides @MatchITAppScope
    internal  fun provideStethoNetworkInterceptor()  = StethoInterceptor()

//    @Provides @MatchITAppScope @Named("MockInterceptor")
//    internal fun provideMockInterceptor() = MockInterceptor()
}