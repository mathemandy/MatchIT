package ng.mathemandy.matchit.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import ng.mathemandy.matchit.MatchITApplication
import ng.mathemandy.matchit.di.modules.global.MatchITApplicationModule
import ng.mathemandy.matchit.di.modules.presentation.MatchITActivityModule
import ng.mathemandy.matchit.di.scopes.MatchITAppScope


@MatchITAppScope
@Component(modules = [AndroidSupportInjectionModule::class, AndroidInjectionModule::class,
    MatchITApplicationModule::class, MatchITActivityModule::class])
interface MatchITApplicationComponent: AndroidInjector<DaggerApplication> {
    @Component.Builder
   interface  Builder {
       @BindsInstance fun bindMatchITApplicationInstance(application: MatchITApplication): Builder
       fun buildMatchITApplicationComponent() : MatchITApplicationComponent
   }
}