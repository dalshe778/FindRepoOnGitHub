package com.example.lisa.findrepo.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.uiautomator.UiSelector
import com.example.lisa.findrepo.R
import org.junit.Assert

class SearchScreen: BaseScreen() {
    val searchScreen = uiDevice.findObject(UiSelector().resourceId("android:id/content"))
    val searchRepoField = onView(withId(R.id.searchEditText))
    val searchRepoButton = onView(withId(R.id.searchButton))
    val searchUserField = onView(withId(R.id.userRepoEditText))
    val searchUserButton = onView(withId(R.id.userRepoButton))

    init {
        Assert.assertTrue("Search screen is not displayed", searchScreen.waitForExists(5000))
    }

    fun clearRepoSearch(){
        searchRepoField.perform(clearText())
    }
    fun clickOnSearchRepo(): SearchResultScreen {
        searchRepoButton.perform(click())
        return SearchResultScreen()
    }
    fun clearUserSearch(){
        searchUserField.perform(clearText())
    }
    fun clickOnUserSearch(): SearchResultScreen {
        searchUserButton.perform(click())
        return SearchResultScreen()
    }
    fun setRepoText(string: String){
        searchRepoField.perform(typeText(string))
    }
    fun setUserText(string: String){
        searchUserField.perform(typeText(string))
    }
    fun checkRepoHint(string: String){
        searchRepoField.check(matches(withHint(string)))
    }
    fun checkUserHint(string: String){
        searchUserField.check(matches(withHint(string)))
    }
}