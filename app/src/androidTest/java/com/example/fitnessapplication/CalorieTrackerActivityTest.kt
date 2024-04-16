package com.example.fitnessapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalorieTrackerActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<CalorieTrackerActivity> = ActivityScenarioRule(CalorieTrackerActivity::class.java)

    @Test
    fun testAddGoalUpdatesCalories() {
        // Click on 'Add Goal' button
        onView(withId(R.id.buttonAdd)).perform(click())

        // Enter a new goal
        onView(withId(R.id.editTextGoal)).perform(typeText("1500"))

        // Click 'Add' button in the dialog to confirm
        onView(withText("Add")).perform(click())

        // Check if goal display is updated
        onView(withId(R.id.textGoal)).check(matches(withText("1500")))
    }

    @Test
    fun testAddFoodIncreasesCaloriesConsumed() {
        // Assume the user already has a goal set for simplicity in testing
        testAddGoalUpdatesCalories()

        // Click on 'Add Item Breakfast' button
        onView(withId(R.id.buttonAddItemBreakfast)).perform(click())

        // Enter food name and calories
        onView(withId(R.id.editTextFoodName)).perform(typeText("Oatmeal"))
        onView(withId(R.id.editTextCalories)).perform(typeText("350"))

        // Click 'Add' button in the dialog to confirm
        onView(withText("Add")).perform(click())

        // Check if food calories display is updated
        onView(withId(R.id.textFood)).check(matches(withText("350")))
    }

    @Test
    fun testRemainingCaloriesCalculation() {
        // Assume the user has set a goal and added some food
        testAddGoalUpdatesCalories()
        testAddFoodIncreasesCaloriesConsumed()

        // Check the calculation for remaining calories
        // Assuming no exercise, remaining should be goal - food calories
        onView(withId(R.id.textTotal)).check(matches(withText("1150"))) // 1500 - 350
    }
}
