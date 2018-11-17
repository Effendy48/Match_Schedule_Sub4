package com.example.lenovo.match_schedule.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import com.example.lenovo.match_schedule.MainActivity
import com.example.lenovo.match_schedule.R
import com.example.lenovo.match_schedule.R.id.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    //Add or Remove Favorite and Show In Fragment Favorite
    @Test
    fun testAddRemoveFavorite(){
        Thread.sleep(3000)
        onView(withId(list_past_match))
                .check(matches(isDisplayed()))
        Thread.sleep(3000)
        onView(withId(list_past_match)).perform(
                RecyclerViewActions.scrollToPosition
                <RecyclerView.ViewHolder>(2))
        onView(withId(list_past_match)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        Thread.sleep(3000)
        onView(withId(R.id.add_to_favorite)).perform(click())
        Thread.sleep(1000)
        pressBack()
        Thread.sleep(1000)
        onView(withId(favorites)).perform(click())
    }

    //Test Pada Recycler View di fragment past_match
    @Test
    fun testRecyclerViewBehaviour() {
        Thread.sleep(3000)
        onView(withId(list_past_match))
                .check(matches(isDisplayed()))
        Thread.sleep(3000)
        onView(withId(list_past_match)).perform(
                RecyclerViewActions.scrollToPosition
                <RecyclerView.ViewHolder>(10))
        onView(withId(list_past_match)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))
        Thread.sleep(3000)
        pressBack()
    }

    //Mengetest BottomNavigation per Masing-Masing Fragment
    @Test
    fun testBottomNavigation(){
        Thread.sleep(2000)
        onView(withId(past_match)).perform(click())

        Thread.sleep(2000)
        onView(withId(next_match)).perform(click())

        Thread.sleep(2000)
        onView(withId(favorites)).perform(click())

        Thread.sleep(2000)
        onView(withId(past_match)).perform(click())
    }

}