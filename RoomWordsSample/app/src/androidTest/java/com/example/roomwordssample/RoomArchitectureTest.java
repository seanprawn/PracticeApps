package com.example.roomwordssample;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class RoomArchitectureTest {

    @Rule
   public ActivityScenarioRule mActivityTestRule = new ActivityScenarioRule(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.roomwordssample", appContext.getPackageName());
    }

    @Test
    public void ActivityLaunch()
    {
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.edit_word)).check(matches(isDisplayed()));
        onView(withId(R.id.edit_word)).perform(typeText("Karen"));
//        onView(withId(R.id.edit_word)).check(matches(withText("Karen"))); // Useless Test!
        onView(withId(R.id.button_save)).perform(click());
    }
}