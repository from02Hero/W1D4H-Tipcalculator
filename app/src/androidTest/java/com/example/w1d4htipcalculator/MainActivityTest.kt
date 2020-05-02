package com.example.w1d4htipcalculator

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.w1d4htipcalculator.ScreenRobot.Companion.withRobot

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun onLaunchCheckAmountInputIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.inputAmount))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun onLaunchRoundUpToNearestIsDisplayed() {
        Espresso.onView(ViewMatchers.withText(R.string.round_up_to_nearest))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun whenOkayButtonIsPressedAndAmountIsEmptyTipIsEmpty() {
        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectOkayButton("")
            .verifyTipIsCorrect("")
    }

    @Test
    fun whenOkayButtonIsPressedAndAmountIsFilledTipIsSet() {
        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyPercentIsCorrect("18.00%")
            .verifyTipIsCorrect("1.98")
            .verifyTotalIsCorrect("12.98")
    }

    @Test
    fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedAmountIsCorrect() {
        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.switchRound)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyPercentIsCorrect("18.18%")
            .verifyTipIsCorrect("2.00")
            .verifyTotalIsCorrect("13.00")
    }

    class CalculatorScreenRobot : ScreenRobot<CalculatorScreenRobot>() {
        fun verifyTipIsCorrect(tip: String): CalculatorScreenRobot {
            return checkViewHasText(R.id.textTip, tip)
        }

        fun verifyTotalIsCorrect(total: String): CalculatorScreenRobot {
            return checkViewHasText(R.id.textTotal, total)
        }

        fun verifyPercentIsCorrect(total: String): CalculatorScreenRobot {
            return checkViewHasText(R.id.textPercent, total)
        }

        fun inputCheckAmountAndSelectOkayButton(input: String):
                CalculatorScreenRobot {
            return enterTextIntoView(R.id.inputAmount, input)
                .clickOkOnView(R.id.buttonOkay)
        }
    }
}
