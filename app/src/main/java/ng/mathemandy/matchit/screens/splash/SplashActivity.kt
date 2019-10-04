package ng.mathemandy.matchit.screens.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import ng.mathemandy.core.base.BaseActivity
import ng.mathemandy.core.utils.state.MatchITStatus
import ng.mathemandy.matchit.BR
import ng.mathemandy.matchit.R
import ng.mathemandy.matchit.databinding.ActivitySplashBinding
import ng.mathemandy.matchit.screens.splash.viewModel.SplashActivityViewModel
import ng.mathemandy.navigation.MatchITIntentKey
import ng.mathemandy.navigation.MatchITNavigator
import javax.inject.Inject

class SplashActivity: BaseActivity<ActivitySplashBinding, SplashActivityViewModel>() {

    @Inject
    lateinit var splashActivityViewModel: SplashActivityViewModel


    @Inject lateinit var matchITNavigator: MatchITNavigator

    private  lateinit var  binding: ActivitySplashBinding

    override fun getViewModel(): SplashActivityViewModel = splashActivityViewModel

    override fun getLayoutResourceId(): Int  = R.layout.activity_splash

    override fun getBindingVariable(): Int  = BR.ViewModel

    override fun getBinding(binding: ActivitySplashBinding) {
        this.binding = binding
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashActivityViewModel.loggedInUser.observe(this, Observer {
            when (it.status) {
                MatchITStatus.SUCCESS ->    startActivity(matchITNavigator.createIntent(this, MatchITIntentKey.Main()))
                MatchITStatus.FAILED ->    startActivity(matchITNavigator.createIntent(this, MatchITIntentKey.Authentication()))


            }
        })

    }
}