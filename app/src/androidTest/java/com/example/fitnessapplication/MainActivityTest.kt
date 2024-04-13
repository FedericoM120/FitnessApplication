package com.example.fitnessapplication

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

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testLoginSuccess() {
        onView(withId(R.id.username)).perform(typeText("admin"))
        onView(withId(R.id.password)).perform(typeText("admin"))
        onView(withId(R.id.loginButton)).perform(click())
        onView(withId(R.id.textViewTitle)).check(matches(isDisplayed()))
    }
}
