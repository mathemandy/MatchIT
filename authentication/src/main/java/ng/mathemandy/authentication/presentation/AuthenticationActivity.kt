package ng.mathemandy.authentication.presentation

import android.content.Context
import android.content.Intent
import ng.mathemandy.authentication.BR
import ng.mathemandy.authentication.R
import ng.mathemandy.authentication.databinding.ActivityAuthenticationBinding
import ng.mathemandy.authentication.viewmodel.AuthenticationActivityViewModel
import ng.mathemandy.core.base.BaseActivity
import ng.mathemandy.navigation.MatchITIntentKey
import ng.mathemandy.navigation.MatchITIntentResolver
import javax.inject.Inject

class AuthenticationActivity : BaseActivity<ActivityAuthenticationBinding, AuthenticationActivityViewModel>(){


    @Inject
    lateinit var  authenticationActivityViewModel: AuthenticationActivityViewModel
    private lateinit var  binding: ActivityAuthenticationBinding


    override fun getViewModel(): AuthenticationActivityViewModel  = authenticationActivityViewModel

    override fun getLayoutResourceId(): Int  = R.layout.activity_authentication

    override fun getBindingVariable(): Int  = BR.ViewModel

    override fun getBinding(binding: ActivityAuthenticationBinding) {
        this.binding = binding
    }
    companion object : MatchITIntentResolver<MatchITIntentKey.Authentication>{
        override fun getIntent(context: Context, key: MatchITIntentKey.Authentication?): Intent {
            return Intent(context, AuthenticationActivity::class.java)
        }
        fun getStartIntent(context: Context) = Intent(context, AuthenticationActivity::class.java)

    }


}