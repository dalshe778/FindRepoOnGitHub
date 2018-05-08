package com.example.lisa.findrepo.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import com.example.lisa.findrepo.R

class SearchScreen: BaseScreen() {
    val searchRepoField = Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
    val searchRepoButton = Espresso.onView(ViewMatchers.withId(R.id.searchButton))
    val searchUserField = Espresso.onView(ViewMatchers.withId(R.id.userRepoEditText))
    val searchUserButton = Espresso.onView(ViewMatchers.withId(R.id.userRepoButton))

    fun clearRepoSearch(){
        searchRepoField.perform(ViewActions.clearText())
    }
    fun clickOnSearchRepo(){
        searchRepoButton.perform(ViewActions.click())
    }
    fun clearUserSearch(){
        searchUserField.perform(ViewActions.clearText())
    }
    fun clickOnUserSearch(){
        searchUserButton.perform(ViewActions.click())
    }




}