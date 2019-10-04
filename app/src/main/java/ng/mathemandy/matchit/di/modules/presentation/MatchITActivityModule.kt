package ng.mathemandy.matchit.di.modules.presentation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ng.mathemandy.authentication.presentation.AuthenticationActivity
import ng.mathemandy.matchit.di.scopes.PerActivity
import ng.mathemandy.matchit.screens.main.MainActivity
import ng.mathemandy.matchit.screens.splash.SplashActivity

@Module
abstract class MatchITActivityModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindsSplashActivity(): SplashActivity


    @PerActivity
    @ContributesAndroidInjector
    abstract  fun bindsMainActivity(): MainActivity


    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindAuthenticationActivity(): AuthenticationActivity


}