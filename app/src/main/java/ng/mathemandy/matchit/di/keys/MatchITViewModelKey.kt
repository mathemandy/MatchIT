package ng.mathemandy.matchit.di.keys

import dagger.MapKey
import ng.mathemandy.core.base.BaseViewModel
import kotlin.reflect.KClass


@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal  annotation class MatchITViewModelKey(val value: KClass<out BaseViewModel>)