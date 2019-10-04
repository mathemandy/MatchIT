package ng.mathemandy.matchit.di.modules.global

import android.content.Context
import dagger.Binds
import dagger.Module
import ng.mathemandy.domain.utils.RxObservationThread
import ng.mathemandy.matchit.MatchITApplication
import ng.mathemandy.matchit.di.modules.local.MatchITLocalModule
import ng.mathemandy.matchit.di.modules.presentation.MatchITActivityModule
import ng.mathemandy.matchit.di.modules.presentation.MatchITFragmentModule
import ng.mathemandy.matchit.di.modules.presentation.MatchITNavigationModule
import ng.mathemandy.matchit.di.modules.presentation.MatchITViewModelModule
import ng.mathemandy.matchit.di.modules.remote.MatchITRemoteModule
import ng.mathemandy.matchit.di.modules.repository.MatchITRepositoryModule
import ng.mathemandy.matchit.di.scopes.MatchITAppScope
import ng.mathemandy.matchit.utils.MatchITObservationThread


@Module(
    includes = [
        MatchITViewModelModule::class,
        MatchITActivityModule::class,
        MatchITFragmentModule::class,
        MatchITNavigationModule::class,
        MatchITRepositoryModule::class,
        MatchITRemoteModule::class,
        MatchITLocalModule::class
    ]
)
abstract class MatchITApplicationModule {

    @Binds
    @MatchITAppScope
    internal abstract fun bindsMatchITApplicationContext(
        application: MatchITApplication
    ): Context

    @Binds
    @MatchITAppScope
    internal abstract fun bindsMatchITExecutionThread(
        observationThread: MatchITObservationThread
    ): RxObservationThread

}