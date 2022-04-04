package ru.samsung.itacademy.mdev.twoactivitiesespressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = activityScenarioRule<MainActivity>()

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun sendMessage() {
        onView(withId(R.id.text_message_reply)).check(matches(ViewMatchers.withText("")))
        onView(withId(R.id.editText_main)).perform(ViewActions.typeText("asd"))
        onView(withId(R.id.button_main)).perform(ViewActions.click())
        onView(withId(R.id.text_message)).check(matches(ViewMatchers.withText("asd")))
    }

    @Test
    fun sendAndReceive() {
        onView(withId(R.id.text_message_reply)).check(matches(ViewMatchers.withText("")))
        onView(withId(R.id.editText_main)).perform(ViewActions.typeText("asd"))
        onView(withId(R.id.button_main)).perform(ViewActions.click())
        onView(withId(R.id.text_message)).check(matches(ViewMatchers.withText("asd")))
        onView(withId(R.id.editText_second)).perform(ViewActions.typeText("dsa"))
        onView(withId(R.id.button_second)).perform(ViewActions.click())
        onView(withId(R.id.text_message_reply)).check(matches(ViewMatchers.withText("dsa")))
    }
}
