package com.android.nytimes_milansexercise.Activity

import androidx.test.espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.android.nytimes_milansexercise.Adapter.AdapterArticleList
import com.android.nytimes_milansexercise.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    @Rule
    @JvmField
    var  activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSelectItem(){
        Espresso.onView(withId(R.id.recycler_article)).perform(actionOnItemAtPosition<AdapterArticleList.Holder>(4, click()))
    }

}