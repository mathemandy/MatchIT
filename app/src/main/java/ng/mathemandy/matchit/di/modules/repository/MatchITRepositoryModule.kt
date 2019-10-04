package ng.mathemandy.matchit.di.modules.repository

import dagger.Binds
import dagger.Module
import ng.mathemandy.domain.repository.authentication.IAuthenticationRepository
import ng.mathemandy.matchit.di.scopes.MatchITAppScope
import ng.mathemandy.repository.impl.authentication.AuthenticationRepositoryImpl

@Module
abstract  class MatchITRepositoryModule  {


    @Binds
    @MatchITAppScope
    internal abstract fun bindMatchITAuthenticationRepository(
        repository: AuthenticationRepositoryImpl
    ): IAuthenticationRepository


}