package com.example.lisa.findrepo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.clearText
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoTests {

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    //val idlingResource =

    @Test
    fun checkDefaultSearchRepoTerm() {
        //To check that default search parameter is equal to "Fuel"
        //when user clicks on search button without typing anything
        //and return back to the main screen
        onView(withId(R.id.searchEditText))
                .perform(clearText())
        onView(withId(R.id.searchButton))
                .perform(click())
        Thread.sleep(10000)

        pressBack()

        //Choose random repo from the list and assert that the name contains 'fuel'
        //onData(anything()).inAdapterView(withId(R.id.repoListView)).atPosition(0).perform(click())

        //pressBack()
    }
}