package com.example.lisa.findrepo

import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.clearText
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.lisa.findrepo.Screens.SearchScreen
import junit.framework.Assert
import org.hamcrest.Matchers.anything
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class EspressoTests: BaseTest() {

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun checkDefaultSearchRepoTerm() {
        //To verify that default search Repo parameter is equal to "fuel"
        //and return back to the main screen
        val searchScreen = SearchScreen()
        searchScreen.clearRepoSearch()
        val searchResultScreen = searchScreen.clickOnSearchRepo()
        Thread.sleep(5000)
        val numberOfItems = searchResultScreen.numberOfItems()
        val randomNumber = Random().nextInt(numberOfItems)
        val randomRepo = searchResultScreen.repoByIndex(randomNumber)
        val randomRepoName = randomRepo.repoName
        Assert.assertTrue("Repo name doesn't contain fuel", randomRepoName.contains("fuel"))
        pressBack()
    }

    @Test
    fun checkGitHubPage() {
        //To verify that GitHub page is open after clicking on random repo from the list
        //and return back to the main screen
        val searchScreen = SearchScreen()
        searchScreen.clearRepoSearch()
        val newSearch = "findrepo"
        searchScreen.setRepoText(newSearch)
        val searchResultScreen = searchScreen.clickOnSearchRepo()
        Thread.sleep(10000)
        val numberOfItems = searchResultScreen.numberOfItems()
        val randomNumber = Random().nextInt(numberOfItems)
        val gitHubScreen = searchResultScreen.clickOnItem(randomNumber)
        val urlBar = gitHubScreen.urlBar
        Assert.assertTrue("Browser screen is not displayed", urlBar.waitForExists(5000))
        uiDevice.pressBack()
        pressBack()
        searchScreen.clearRepoSearch()
    }

    @Test
    fun checkHintIsPresent() {
        //To verify that User Search hint is present after user performs a search
        //and returns back to the main screen
        val searchScreen = SearchScreen()
        searchScreen.clearUserSearch()
        val newUserSearch = "lisalogvinova"
        searchScreen.setUserText(newUserSearch)
        val searchResultScreen = searchScreen.clickOnUserSearch()
        Thread.sleep(5000)
        pressBack()
        searchScreen.clearUserSearch()
        val hint = "View User's Repos"
        searchScreen.checkUserHint(hint)
    }

    @Test
    fun checkSnackbarIsPresent() {
        //To verify that Snackbar shows up when user performs an empty User search
        //and return back to the main screen
        val searchScreen = SearchScreen()
        searchScreen.clearUserSearch()
        val searchResultScreen = searchScreen.clickOnUserSearch()
        searchResultScreen.checkSnackbar()
        pressBack()
    }
}