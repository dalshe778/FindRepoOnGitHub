package com.example.lisa.findrepo.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.uiautomator.UiCollection
import android.support.test.uiautomator.UiSelector
import com.example.lisa.findrepo.R
import org.hamcrest.Matchers.anything
import org.junit.Assert

class SearchResultScreen: BaseScreen(){
    val searchResultList = UiCollection(UiSelector().resourceId("com.example.lisa.findrepo:id/repoListView"))

    init {
        Assert.assertTrue("Expected elements are not displayed", searchResultList.waitForExists(5000))
    }

    val searchItem = UiSelector().resourceId("com.example.lisa.findrepo:id/linearLayout")
    val list = onData(anything()).inAdapterView(withId(R.id.repoListView))

    fun numberOfItems(): Int {
        return searchResultList.getChildCount(searchItem)
    }

    fun clickOnItem(index: Int){
        list.atPosition(index).perform(click())
    }





}
