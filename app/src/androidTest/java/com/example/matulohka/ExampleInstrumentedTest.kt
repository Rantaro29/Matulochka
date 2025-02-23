package com.example.matulohka

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.matulohka.presentation.activity.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@LargeTest
@RunWith(AndroidJUnit4::class)

class ExampleInstrumentedTest {

    private val invalidEmail = "asd@d"
    private val invalidPassword = "dafaAsdaf"

    private val validEmail = "user@gmail.com"
    private val validPassword = "User1234/"

    private val validLoginEmail = "user@gmail.com"
    private val validLoginPassword = "User1234."

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.matulohka", appContext.packageName)
    }

    @Test
    fun invalidEmail(){
        onView(withId(R.id.LogInEmailEditText)).check(matches(isDisplayed())).perform(typeText(invalidEmail))
        onView(withId(R.id.LogInPasswordEditText)).check(matches(isDisplayed())).perform(typeText(invalidPassword))
        onView(withId(R.id.singInButton)).check(matches(isDisplayed())).perform(click())
        onView(withText("Invalid Email")).check(matches(isDisplayed()))
    }

    @Test
    fun invalidPassword(){
        onView(withId(R.id.LogInEmailEditText)).check(matches(isDisplayed())).perform(typeText(validEmail))
        onView(withId(R.id.LogInPasswordEditText)).check(matches(isDisplayed())).perform(typeText(invalidPassword))
        onView(withId(R.id.singInButton)).check(matches(isDisplayed())).perform(click())
        onView(withText("Invalid Password")).check(matches(isDisplayed()))
    }

    @Test
    fun invalidLogin(){
        onView(withId(R.id.LogInEmailEditText)).check(matches(isDisplayed())).perform(typeText(validEmail))
        onView(withId(R.id.LogInPasswordEditText)).check(matches(isDisplayed())).perform(typeText(validPassword))
        onView(withId(R.id.singInButton)).check(matches(isDisplayed())).perform(click())
        Thread.sleep(5000)
        onView(withText("Invalid Login")).check(matches(isDisplayed()))
    }

    @Test
    fun validLogin(){
        onView(withId(R.id.LogInEmailEditText)).check(matches(isDisplayed())).perform(typeText(validLoginEmail))
        onView(withId(R.id.LogInPasswordEditText)).check(matches(isDisplayed())).perform(typeText(validLoginPassword))
        onView(withId(R.id.singInButton)).check(matches(isDisplayed())).perform(click())
        Thread.sleep(5000)
        onView(withId(R.id.homeFragment)).check(matches(isDisplayed()))
    }
}