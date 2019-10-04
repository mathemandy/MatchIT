package ng.mathemandy.matchit.remote.retrofit

import dagger.Module
import dagger.Provides
import ng.mathemandy.matchit.BuildConfig
import ng.mathemandy.matchit.di.scopes.MatchITAppScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes =  [OkhttpClientModule::class, NetworkFactoriesModule::class])
class  RetrofitModule {

    @Provides
    @MatchITAppScope
    fun provideRetrofit (
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(client)
        builder.addCallAdapterFactory(rxJava2CallAdapterFactory)
        builder.addConverterFactory(gsonConverterFactory)
        builder.baseUrl(BuildConfig.BASE_URL)
        return  builder.build()
    }
}