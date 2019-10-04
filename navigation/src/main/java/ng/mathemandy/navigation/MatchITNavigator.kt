package ng.mathemandy.navigation

import android.content.Context
import android.content.Intent
import java.lang.IllegalArgumentException
import javax.inject.Inject

class MatchITNavigator @Inject constructor(
    private val matchITIntentResolvers: MatchITIntentResolverMap
) {

  open  fun createIntent(context: Context, intentKey: MatchITIntentKey): Intent {
        val resolver =
            matchITIntentResolvers[intentKey::class.java]?.get() as MatchITIntentResolver<MatchITIntentKey>?
        return resolver?.getIntent(context, intentKey)
            ?: throw  IllegalArgumentException("Cannot resolve intent key $intentKey")
    }
}