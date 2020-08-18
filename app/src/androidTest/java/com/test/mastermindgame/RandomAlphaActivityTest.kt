package com.test.mastermindgame



import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not


class RandomAlphaActivityTest {

    @Rule @JvmField val activityTestRule = ActivityTestRule(RandomAlphaActivity::class.java, true, true)

    @Test
    fun isAllEditboxAvailable() {
        SystemClock.sleep(3500)
        onView(withId(R.id.edt0))
            .check(matches(isDisplayed()))
        onView(withId(R.id.edt1))
            .check(matches(isDisplayed()))
        onView(withId(R.id.edt2))
            .check(matches(isDisplayed()))
        onView(withId(R.id.edt3))
            .check(matches(isDisplayed()))
    }

    @Test
    fun validateonCheckboxClick() {
        SystemClock.sleep(3500)
        onView(withId(R.id.edt0)).perform(ViewActions.clearText())
        onView(withId(R.id.edt1)).perform(ViewActions.clearText())
        onView(withId(R.id.edt2)).perform(ViewActions.clearText())
        onView(withId(R.id.edt3)).perform(ViewActions.clearText())
        onView(withId(R.id.cbxSubmit)).perform(ViewActions.click())

        }

    @Test
    fun enterRandomString() {
        SystemClock.sleep(3500)
        onView(withId(R.id.edt0))
            .perform(ViewActions.typeText("a"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.edt1))
            .perform(ViewActions.typeText("b"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.edt2))
            .perform(ViewActions.typeText("c"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.edt3))
            .perform(ViewActions.typeText("d"), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.cbxSubmit)).perform(ViewActions.click())

        }



}