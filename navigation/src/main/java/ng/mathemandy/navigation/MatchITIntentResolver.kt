package ng.mathemandy.navigation

import android.content.Context
import android.content.Intent

interface MatchITIntentResolver <in KEY: MatchITIntentKey>{
    fun getIntent(context: Context, key : KEY?) : Intent
}