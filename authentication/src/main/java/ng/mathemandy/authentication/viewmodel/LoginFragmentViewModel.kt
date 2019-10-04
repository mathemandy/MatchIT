package ng.mathemandy.authentication.viewmodel

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ng.mathemandy.authentication.mappers.authentication.MatchITUserModelMapper
import ng.mathemandy.authentication.model.MatchITAuthUser
import ng.mathemandy.core.base.BaseViewModel
import ng.mathemandy.core.utils.MatchITLog
import ng.mathemandy.core.utils.state.MatchITResource
import ng.mathemandy.domain.interactors.authentication.GetPreviousUser
import ng.mathemandy.domain.interactors.authentication.SignUserIn
import javax.inject.Inject

class LoginFragmentViewModel @Inject constructor(
    private val signUserIn: SignUserIn,
    private val previousUser: GetPreviousUser,
    private val userModelMapper: MatchITUserModelMapper
): BaseViewModel() {



    val email = MutableLiveData<String>().apply { value = "andyeshiet@gmail.com" }
    val userName = MutableLiveData<String>().apply { value = "Welcome back [mathemandy]" }
    val password = MutableLiveData<String>().apply { value = "123456" }

    private val _userLoginLiveData = MutableLiveData<MatchITResource<MatchITAuthUser>>()
    val userLoginLiveData = _userLoginLiveData as LiveData<MatchITResource<MatchITAuthUser>>


    fun loginUser(){
        if (TextUtils.isEmpty(userName.value)) {
            _userLoginLiveData.postValue(
                MatchITResource.validationError(
                    field = EMAIL_FIELD,
                    message = "Field is empty"
                )
            )
            return
        }
        if (TextUtils.isEmpty(password.value)) {
            _userLoginLiveData.postValue(
                MatchITResource.validationError(
                    field = PASSWORD_FIELD,
                    message = "Field is empty"
                )
            )
            return
        }
        _userLoginLiveData.postValue(
            MatchITResource.loading()
        )

        signUserIn.executeUseCaseAndPerformAction(SignUserIn.SignInParameters.make(
            email = email.value!!,
            password = password.value!!
        ), {
            _userLoginLiveData.postValue(
                MatchITResource.success(
                    data = userModelMapper.mapToAuthentication(it.data!!)
                )
            )
        }){
            _userLoginLiveData.postValue(
                MatchITResource.failed(it.message)
            )
            MatchITLog.logException(it)
        }


    }

    fun getPreviousUser (){
        previousUser.executeUseCaseAndPerformAction(null, {
            if (it.data != null ){
                email.postValue(it.data?.email)
                userName.postValue("Welcome back [${it.data?.userName}]")
            }

        }, {


        } )


    }



    companion object {
        const val EMAIL_FIELD = "Email Field"
        const val PASSWORD_FIELD = "Password Field"
    }

}