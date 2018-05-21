package com.example.lisa.findrepo.Screens

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.uiautomator.UiCollection
import android.support.test.uiautomator.UiObject
import android.support.test.uiautomator.UiSelector
import com.example.lisa.findrepo.R
import org.hamcrest.Matchers.*
import org.junit.Assert

class SearchResultScreen: BaseScreen(){
    private val searchResultList = UiCollection(UiSelector().resourceId("com.example.lisa.findrepo:id/repoListView"))

    init {
        Assert.assertTrue("Expected elements are not displayed", searchResultList.waitForExists(5000))
    }

    val searchItem = UiSelector().resourceId("com.example.lisa.findrepo:id/linearLayout")
    val repoList = onData(anything()).inAdapterView(withId(R.id.repoListView))
    val repoItemMatcher =  withId(R.id.repoTextView)
    val snackbar = onView(withId(R.id.snackbar_text))

    fun numberOfItems(): Int {
        return searchResultList.getChildCount(searchItem)
    }
    fun repoByIndex(index: Int): RepoItem {
        return RepoItem(searchResultList.getChildByInstance(searchItem, index))
    }
    fun clickOnItem(index: Int): GitHubScreen {
        repoList.atPosition(index).perform(click())
        return GitHubScreen()
    }
    fun checkSnackbar(){
        snackbar.check(matches(isDisplayed()))
    }
}

class RepoItem(private val itemObject: UiObject) {
    private val nameSelector = UiSelector().resourceId("com.example.lisa.findrepo:id/repoTextView")
    public val repoName = itemObject.getChild(nameSelector).text
}