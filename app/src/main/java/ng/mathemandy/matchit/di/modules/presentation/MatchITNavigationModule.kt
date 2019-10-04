package ng.mathemandy.matchit.di.modules.presentation

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ng.mathemandy.authentication.presentation.AuthenticationActivity
import ng.mathemandy.matchit.di.keys.MatchITIntentResolverKey
import ng.mathemandy.matchit.screens.main.MainActivity
import ng.mathemandy.navigation.MatchITIntentKey
import ng.mathemandy.navigation.MatchITIntentResolver


@Module
class MatchITNavigationModule {

    @[
    Provides
    IntoMap
    MatchITIntentResolverKey(MatchITIntentKey.Main::class)
    ]
    internal fun provideMainActivityIntentResolver(): MatchITIntentResolver<*> {
        return MainActivity
    }

    @[
    Provides
    IntoMap
    MatchITIntentResolverKey(MatchITIntentKey.Authentication::class)
    ]
    internal fun provideAuthenticationActivityIntentResolver(): MatchITIntentResolver<*> {
        return AuthenticationActivity
    }

}
