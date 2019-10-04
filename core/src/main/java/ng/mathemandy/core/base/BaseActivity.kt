package ng.mathemandy.core.base

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import ng.mathemandy.core.R


abstract  class BaseActivity<in D: ViewDataBinding, out V: ViewModel> : DaggerAppCompatActivity(){

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        initializeDataBinding()
        createDialog()
        observeLocationChanges()
    }

    private fun initializeDataBinding(){
        val binding: D = DataBindingUtil.setContentView(this, getLayoutResourceId())
        binding.setVariable(getBindingVariable(), getViewModel())
        binding.executePendingBindings()
        getBinding(binding)
    }

    private fun createDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.layout_progress_dialog)
        builder.setCancelable(false)

        dialog = builder.create()
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun hideKeyboard(activity: Activity) {
        val imm = getSystemService<InputMethodManager>()
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm!!.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showLoadingDialog() {
        dialog.show()
    }

    fun dismissLoadingDialog() {
        if (dialog.isShowing) dialog.dismiss()
    }

    fun showSnackBar(rootView: View, text: String, isError: Boolean = false, duration: Int = Snackbar.LENGTH_SHORT){
        val snackBar = Snackbar.make(rootView, text, duration)
        val param = snackBar.view.layoutParams as CoordinatorLayout.LayoutParams
        val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
        if (isError) snackBarLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.red)) else snackBarLayout.setBackgroundColor(
            ContextCompat.getColor(this, R.color.accent))
        snackBarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).setTextColor(
            if (isError) ContextCompat.getColor(this, R.color.accent) else ContextCompat.getColor(this, R.color.primary)
        )
        param.gravity = Gravity.TOP
        snackBar.view.layoutParams = param

        snackBar.show()
    }

    fun locationIsEnabled(): Boolean {
        val locationManager = getSystemService<LocationManager>()

        val gpsProviderIsEnabled = locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) ?: false
        val networkProviderIsEnabled = locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ?: false

        return gpsProviderIsEnabled || networkProviderIsEnabled
    }

    fun openLocationActivity() {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivity(intent)
    }

    fun refreshActivity() {
        finish()
        startActivity(intent)
    }

    abstract fun getViewModel(): V

    @LayoutRes
    abstract fun getLayoutResourceId(): Int

    abstract fun getBindingVariable(): Int

    abstract fun getBinding(binding: D)

    open fun updateNetworkState(hasActiveInternet: Boolean) {

    }

    /**
     * Used to delegate the location permission request to the activity where it's needed!!
     * Logic to be modified much later
     */
    open fun shouldRequestLocationUpdate() = false

    open fun setUpClickListeners() {

    }

    open fun observeLocationChanges() {

    }

    open fun setupCallbacks() {

    }
}