package com.example.fitnessapplication

// Import necessary Espresso classes for UI testing
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// Specifies that the tests should run using AndroidJUnit4 test runner
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    // Rule to launch the MainActivity before each test
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    // Annotation to mark this method as a test case
    @Test
    fun testLoginSuccess() {
        // Input "admin" into the username field
        onView(withId(R.id.username)).perform(typeText("admin"))

        // Input "admin" into the password field
        onView(withId(R.id.password)).perform(typeText("admin"))

        // Click the login button
        onView(withId(R.id.loginButton)).perform(click())

        // Verify that the textViewTitle is displayed after login success
        onView(withId(R.id.textViewTitle)).check(matches(isDisplayed()))
    }
}

