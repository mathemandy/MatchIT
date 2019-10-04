package ng.mathemandy.matchit.screens.splash.pageobjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import ng.mathemandy.authentication.R
import androidx.test.espresso.action.ViewActions.replaceText

class AuthenticationActivityObject {


    fun typePassword(password : String){
        onView(withId(R.id.passwordET)).perform(replaceText(password))
    }

    fun pressLogIn() {
        onView(withId(R.id.button_login)).perform(click())
    }

}