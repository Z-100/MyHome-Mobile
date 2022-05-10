package com.myhome.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.myhome.R
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class RegisterFragmentTest : TestCase() {

    @Test
    fun test_registerFormAcceptCorrectData() {

        //Setup
        val email = "hans@peter.ch"
        val pw = "ma-ta69"

        val scenario = launchFragmentInContainer<LoginFragment>()

        onView(withId(R.id.inputEmail)).perform(typeText(email))
        onView(withId(R.id.inputEmail)).check(matches(isDisplayed()));

        onView(withId(R.id.inputNewPassword)).perform(typeText(pw))
        onView(withId(R.id.inputNewPassword)).check(matches(isDisplayed()));

        onView(withId(R.id.inputNewRepeatedPassword)).perform(typeText(pw))
        onView(withId(R.id.inputNewRepeatedPassword)).check(matches(isDisplayed()));

        onView(withId(R.id.submitButton)).check(matches(isDisplayed()));
        onView(withId(R.id.submitButton)).perform(click())
    }
}