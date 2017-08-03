package com.github.fernandocchaves.appdemo;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class InteractionTest {

    public final static String NAME_TEXT = "Espresso Android UI Test";
    public final static String PASSWORD_TEXT = "12345";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeTextFields() {

        onView(withId(R.id.nameTxt))
                .perform(typeText(NAME_TEXT), closeSoftKeyboard());

        onView(withId(R.id.passwordTxt))
                .perform(typeText(PASSWORD_TEXT), closeSoftKeyboard());

        onView(withId(R.id.saveBtn)).perform(click());

        onView(withId(R.id.nameView)).check(matches(withText(NAME_TEXT)));
    }
}
