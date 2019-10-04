package ng.mathemandy.matchit.screens.splash.tests

import androidx.test.rule.ActivityTestRule
import io.appflate.restmock.RESTMockServer
import io.appflate.restmock.RequestsVerifier
import io.appflate.restmock.utils.RequestMatchers.pathEndsWith
import ng.mathemandy.authentication.presentation.AuthenticationActivity
import ng.mathemandy.matchit.screens.splash.pageobjects.AuthenticationActivityObject
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AuthenticationActivityTest {

    private val PATH_MATHEMANDY_PROFILE = "mocks/users/mathemandy/index.json"
    private var pageObjects : AuthenticationActivityObject? = null


    @Rule
    @JvmField
    val rule = ActivityTestRule<AuthenticationActivity>(
        AuthenticationActivity::class.java,
        true,
        false
    )

    @Before
    fun setUp() {
        pageObjects = AuthenticationActivityObject()
        RESTMockServer.reset()
    }

    @Test
    fun testLoginSuccess() {
        RESTMockServer.whenGET(pathEndsWith("mathemandy")).thenReturnFile(
            PATH_MATHEMANDY_PROFILE
        )
        //launches  activity
        rule.launchActivity(null)
        pageObjects?.typePassword(PASSWORD)
//        pageObjects?.pressLogIn()
        RequestsVerifier.verifyRequest(pathEndsWith("mathemandy")).invoked()


    }


    fun testNotFound() {
        RESTMockServer.whenGET(pathEndsWith(PASSWORD))
            .thenReturnFile(404, PATH_INTERNAL_ISSUE)
        //launches activity with default intent
        rule.launchActivity(null)
        pageObjects?.typePassword(PASSWORD)
        pageObjects?.pressLogIn()
        RequestsVerifier.verifyRequest(pathEndsWith("login")).invoked()
    }



    companion object {

        const val PASSWORD = "user"
        const val PATH_LOGIN_SUCCESSFUL = "mocks/users/mathemandy/index.json"
        const val PATH_INTERNAL_ISSUE = "mocks/users/internal_issue_summary.json"
        const val PATH_INVALID_PASSWORD = "mocks/users/invalid_password.json"

    }


}