package ng.mathemandy.matchit.di.modules.presentation

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ng.mathemandy.authentication.viewmodel.LoginFragmentViewModel
import ng.mathemandy.core.base.BaseViewModel
import ng.mathemandy.matchit.di.keys.MatchITViewModelKey
import ng.mathemandy.matchit.di.scopes.PerActivity
import ng.mathemandy.matchit.screens.main.viewModel.MainActivityViewModel
import ng.mathemandy.matchit.screens.splash.viewModel.SplashActivityViewModel


@Module
abstract  class  MatchITViewModelModule {



    /*
    * Activity View Model
    * */

    @Binds
    @IntoMap
    @PerActivity
    @MatchITViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindsMainActivityViewModel(
        mainActivityViewModel: MainActivityViewModel
    ): BaseViewModel


    @Binds
    @IntoMap
    @PerActivity
    @MatchITViewModelKey(SplashActivityViewModel::class)
    internal abstract fun bindsSplashActivityViewModel(
        splashActivityViewModel: SplashActivityViewModel
    ): BaseViewModel


    /**
     * Fragment view models
     */
    @Binds
    @IntoMap
    @MatchITViewModelKey(LoginFragmentViewModel::class)
    internal abstract fun bindLoginFragmentViewModel (
        viewModel: LoginFragmentViewModel
    ): BaseViewModel

}