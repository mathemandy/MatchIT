package ng.mathemandy.matchit.screens.splash.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import ng.mathemandy.authentication.presentation.AuthenticationActivity
import ng.mathemandy.matchit.screens.splash.pageobjects.AuthenticationActivityObject
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
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
    }

    @Test
    fun testLoginSuccess() {
        //launches  activity
        rule.launchActivity(null)
        pageObjects?.typePassword(PASSWORD)
        pageObjects?.pressLogIn()

    }




    companion object {

        const val PASSWORD = "user"
        const val PATH_LOGIN_SUCCESSFUL = "mocks/users/mathemandy/index.json"
        const val PATH_INTERNAL_ISSUE = "mocks/users/internal_issue_summary.json"
        const val PATH_INVALID_PASSWORD = "mocks/users/invalid_password.json"

    }


}