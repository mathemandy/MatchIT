package ng.mathemandy.matchit.di.keys

import dagger.MapKey
import ng.mathemandy.navigation.MatchITIntentKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal  annotation class MatchITIntentResolverKey(val value : KClass<out MatchITIntentKey>)