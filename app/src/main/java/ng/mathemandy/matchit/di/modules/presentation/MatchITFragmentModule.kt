package ng.mathemandy.matchit.di.modules.presentation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ng.mathemandy.authentication.fragments.LoginFragment
import ng.mathemandy.matchit.di.scopes.PerFragment

@Module
abstract class MatchITFragmentModule  {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindLoginFragment(): LoginFragment

}