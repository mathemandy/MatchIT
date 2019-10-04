package ng.mathemandy.matchit.remote.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import ng.mathemandy.matchit.di.scopes.MatchITAppScope
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkFactoriesModule  {

    @Provides @MatchITAppScope
    fun provideGsonConverterFactory (
        gson: Gson
    ) : GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides @MatchITAppScope
    internal  fun provideGson()  = GsonBuilder().create()

    @Provides @MatchITAppScope
    fun provideRxJavaAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
}