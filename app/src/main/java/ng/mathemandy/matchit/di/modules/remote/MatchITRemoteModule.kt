package ng.mathemandy.matchit.di.modules.remote

import dagger.Binds
import dagger.Module
import ng.mathemandy.matchit.di.scopes.MatchITAppScope
import ng.mathemandy.matchit.remote.retrofit.RetrofitModule
import ng.mathemandy.remote.impl.authentication.AuthenticationRemoteImpl
import ng.mathemandy.repository.remote.authentication.IMatchITAuthenticationRemote

@Module(includes = [RetrofitModule::class])
abstract class MatchITRemoteModule {



    @Binds
    @MatchITAppScope
    internal  abstract fun bindMatchITAuthenticationRemote(
        authenticationRemote : AuthenticationRemoteImpl
    ): IMatchITAuthenticationRemote



}