package com.example.lisa.findrepo.Screens

import android.support.test.uiautomator.UiSelector
import org.junit.Assert

class GitHubScreen: BaseScreen(){
    val gitHubScreen = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/coordinator"))

    init {
        Assert.assertTrue("Browser screen is not displayed", gitHubScreen.waitForExists(5000))
    }

    val urlBar = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))
    val actualUrl get() = urlBar.text
}