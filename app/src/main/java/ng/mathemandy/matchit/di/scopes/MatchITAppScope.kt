package ng.mathemandy.matchit.di.scopes

import javax.inject.Scope


@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
@Scope
annotation class MatchITAppScope