package com.example.lisa.findrepo.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.uiautomator.UiSelector
import com.example.lisa.findrepo.R
import org.junit.Assert

class SearchScreen: BaseScreen() {
    val searchScreen = uiDevice.findObject(UiSelector().resourceId("android:id/content"))
    val searchRepoField = Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
    val searchRepoButton = Espresso.onView(ViewMatchers.withId(R.id.searchButton))
    val searchUserField = Espresso.onView(ViewMatchers.withId(R.id.userRepoEditText))
    val searchUserButton = Espresso.onView(ViewMatchers.withId(R.id.userRepoButton))

    init {
        Assert.assertTrue("Search screen is not displayed", searchScreen.waitForExists(5000))
    }

    fun clearRepoSearch(){
        searchRepoField.perform(ViewActions.clearText())
    }
    fun clickOnSearchRepo(): SearchResultScreen {
        searchRepoButton.perform(ViewActions.click())
        return SearchResultScreen()
    }
    fun clearUserSearch(){
        searchUserField.perform(ViewActions.clearText())
    }
    fun clickOnUserSearch(): SearchResultScreen {
        searchUserButton.perform(ViewActions.click())
        return SearchResultScreen()
    }

    fun setRepoText(string: String){
        searchRepoField.perform(typeText(string))
    }




}