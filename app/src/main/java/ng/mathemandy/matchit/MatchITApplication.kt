package ng.mathemandy.matchit

import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ng.mathemandy.core.utils.MatchITLog
import ng.mathemandy.matchit.di.components.DaggerMatchITApplicationComponent

class MatchITApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        MatchITLog.init()
        Stetho.initializeWithDefaults(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>  =
        DaggerMatchITApplicationComponent.builder().bindMatchITApplicationInstance(this).buildMatchITApplicationComponent()

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}