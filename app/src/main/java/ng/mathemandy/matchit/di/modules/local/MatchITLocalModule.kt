package ng.mathemandy.matchit.di.modules.local

import dagger.Binds
import dagger.Module
import ng.mathemandy.local.IMatchITPreference
import ng.mathemandy.local.impl.MatchITTokenManagerImpl
import ng.mathemandy.local.impl.authentication.MatchITAuthenticationLocalImpl
import ng.mathemandy.matchit.di.scopes.MatchITAppScope
import ng.mathemandy.preference.impl.MatchPreferenceImpl
import ng.mathemandy.repository.local.IMatchITTokenManager
import ng.mathemandy.repository.local.authentication.IMatchITAuthenticationLocal


@Module(
    includes = [
        MatchITRoomModule::class
    ]
)
abstract class MatchITLocalModule {

    @Binds
    @MatchITAppScope
    internal abstract fun bindMatchITPreference (
        matchITPreference: MatchPreferenceImpl
    ): IMatchITPreference

    @Binds
    @MatchITAppScope
    internal abstract fun bindMatchITTokenManager (
        matchITTokenManager: MatchITTokenManagerImpl
    ): IMatchITTokenManager

    @Binds
    @MatchITAppScope
    internal abstract fun bindMatchITAuthenticationLocal (
        matchITAuthenticationLocalImpl: MatchITAuthenticationLocalImpl
    ): IMatchITAuthenticationLocal


}