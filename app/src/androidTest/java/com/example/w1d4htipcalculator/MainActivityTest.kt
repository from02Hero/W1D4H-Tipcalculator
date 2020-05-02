package com.example.w1d4htipcalculator

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.w1d4htipcalculator.ScreenRobot.Companion.withRobot
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setup() {
    }

    @Test
    fun onLaunchCheckAmountInputIsDisplayed() {
    }

    @Test
    fun onLaunchOkayButtonIsDisplayed() {
    }

    @Test
    fun whenOkayButtonIsPressedAndAmountIsEmptyTipIsEmpty() {
    }

    @Test
    fun whenOkayButtonIsPressedAndAmountIsFilledTipIsSet() {
    }

    @Test
    fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedAmountIsCorrect() {
    }

    class CalculatorScreenRobot : ScreenRobot<CalculatorScreenRobot>() {
    }
}