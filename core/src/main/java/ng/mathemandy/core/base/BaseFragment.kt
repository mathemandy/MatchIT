package ng.mathemandy.core.base

import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

abstract  class
BaseFragment<in BINDING: ViewDataBinding, out VIEWMODEL: BaseViewModel>: DaggerFragment(){

    abstract fun getViewModel(): VIEWMODEL

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getBindingVariable(): Int

    abstract fun getLayoutBinding(binding: BINDING)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: BINDING = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.apply {
            setVariable(getBindingVariable(), getViewModel())
            executePendingBindings()
            lifecycleOwner = this@BaseFragment
        }
        getLayoutBinding(binding)
        return binding.root
    }

    fun hideKeyBoard(token: IBinder) {
        val inputMethodManager = activity?.getSystemService<InputMethodManager>()
        inputMethodManager?.hideSoftInputFromWindow(token, 0)
    }

    fun showKeyBoard() {
        val inputMethodManager = activity?.getSystemService<InputMethodManager>()
        inputMethodManager?.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    fun showSnackBar(view: View, message: String, isError: Boolean = false) = (activity as BaseActivity<*, *>).showSnackBar(view, message, isError)

    fun showLoadingDialog() = (activity as BaseActivity<*,*>).showLoadingDialog()

    fun dismissLoadingDialog() = (activity as BaseActivity<*,*>).dismissLoadingDialog()


}