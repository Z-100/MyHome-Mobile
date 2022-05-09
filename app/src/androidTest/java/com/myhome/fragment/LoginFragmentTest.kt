package com.myhome.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.myhome.R
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class LoginFragmentTest : TestCase() {

    @Test
    fun test_loginFormAcceptCorrectData() {

        //Setup
        val email = "hans@peter.ch"
        val pw = "ma-ta69"

        val scenario = launchFragmentInContainer <LoginFragment>(
        )

        onView(withId(R.id.inputEmail).perform(typeText(email)))
        onView(withId(R.id.inputEmail).matches(email))

        onView(withId(R.id.inputEmail).perform(typeText(pw)))
        onView(withId(R.id.inputEmail).matches(pw))
    }
}