package ng.mathemandy.authentication.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import ng.mathemandy.authentication.BR
import ng.mathemandy.authentication.R
import ng.mathemandy.authentication.databinding.FragmentLoginBinding
import ng.mathemandy.authentication.viewmodel.LoginFragmentViewModel
import ng.mathemandy.core.base.BaseFragment
import ng.mathemandy.core.utils.state.MatchITStatus
import javax.inject.Inject

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>() {


    @Inject
    lateinit var loginFragmentViewModel: LoginFragmentViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun getViewModel(): LoginFragmentViewModel = loginFragmentViewModel

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun getBindingVariable(): Int = BR.ViewModel

    override fun getLayoutBinding(binding: FragmentLoginBinding) {
        this.binding = binding
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginFragmentViewModel.getPreviousUser()
        loginFragmentViewModel.userLoginLiveData.observe(this, Observer {
            when (it.status) {
                MatchITStatus.VALIDATION_FAILED -> {
                    binding.passwordET.error = it.message
                }
                MatchITStatus.FAILED -> {
                    dismissLoadingDialog()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                MatchITStatus.LOADING -> showLoadingDialog()

                MatchITStatus.LOADING_MORE -> {

                }
                MatchITStatus.SUCCESS -> {

                    dismissLoadingDialog()
                }
            }
        })
    }

}