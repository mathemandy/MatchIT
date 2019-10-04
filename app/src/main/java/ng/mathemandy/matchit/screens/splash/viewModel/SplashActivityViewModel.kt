package ng.mathemandy.matchit.screens.splash.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ng.mathemandy.authentication.mappers.authentication.MatchITUserModelMapper
import ng.mathemandy.authentication.model.MatchITAuthUser
import ng.mathemandy.core.base.BaseViewModel
import ng.mathemandy.core.utils.MatchITLog
import ng.mathemandy.core.utils.state.MatchITResource
import ng.mathemandy.domain.interactors.authentication.GetUserLoggedIn
import javax.inject.Inject

class SplashActivityViewModel @Inject constructor(
    private val getUserLoggedIn: GetUserLoggedIn,
    private val matchITUserMapper: MatchITUserModelMapper
) : BaseViewModel() {


    private val _loggedInUser = MutableLiveData<MatchITResource<MatchITAuthUser>>()

    val loggedInUser: LiveData<MatchITResource<MatchITAuthUser>>
        get() = _loggedInUser

    init {
        getUserLoggedIn.executeUseCaseAndPerformAction(action = {
            if (it.success) {
                _loggedInUser.postValue(
                    MatchITResource.success(
                        matchITUserMapper.mapToAuthentication(it.data!!)
                    )
                )
            } else {
                _loggedInUser.postValue(
                    MatchITResource.failed(it.message)
                )
            }
        }) {
            MatchITLog.e("$it")
        }
    }

    override fun onCleared() {
        super.onCleared()
        getUserLoggedIn.dispose()
    }
}