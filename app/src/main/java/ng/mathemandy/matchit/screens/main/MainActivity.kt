package ng.mathemandy.matchit.screens.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import ng.mathemandy.core.base.BaseActivity
import ng.mathemandy.matchit.BR
import ng.mathemandy.matchit.R
import ng.mathemandy.matchit.databinding.ActivityMainBinding
import ng.mathemandy.matchit.screens.main.viewModel.MainActivityViewModel
import ng.mathemandy.matchit.utils.extensions.toast
import ng.mathemandy.navigation.MatchITIntentKey
import ng.mathemandy.navigation.MatchITIntentResolver
import javax.inject.Inject


class MainActivity  : BaseActivity<ActivityMainBinding, MainActivityViewModel>(){


    @Inject
    lateinit var  mainActivityViewModel: MainActivityViewModel
    private  lateinit var binding: ActivityMainBinding

    override fun getViewModel(): MainActivityViewModel =  mainActivityViewModel

    override fun getLayoutResourceId(): Int  = R.layout.activity_main

    override fun getBindingVariable(): Int  = BR.ViewModel

    override fun getBinding(binding: ActivityMainBinding) {
        this.binding = binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toast("reached me ", Toast.LENGTH_SHORT)

    }

    companion object : MatchITIntentResolver<MatchITIntentKey.Main> {

        override fun getIntent(context: Context, key: MatchITIntentKey.Main?): Intent {
            return  Intent(context, MainActivity::class.java)
        }

        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)

    }
}