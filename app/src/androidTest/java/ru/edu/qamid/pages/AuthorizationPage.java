package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.edu.qamid.R;

public class AuthorizationPage {

    private final int loginFieldId = R.id.login_edit_text;
    private final int passwordFieldId = R.id.password_edit_text;
    private final int signInButtonId = R.id.enter_button;

    private void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AuthorizationPage enterLogin(String login) {
        waitFor(5000);
        onView(withId(loginFieldId)).check(matches(isDisplayed()));
        onView(withId(loginFieldId)).perform(clearText(), typeText(login), closeSoftKeyboard());
        return this;
    }

    public AuthorizationPage enterPassword(String password) {
        waitFor(1000);
        onView(withId(passwordFieldId)).check(matches(isDisplayed()));
        onView(withId(passwordFieldId)).perform(clearText(), typeText(password), closeSoftKeyboard());
        return this;
    }

    public MainPage clickSignIn() {
        waitFor(500);
        onView(withId(signInButtonId)).check(matches(isDisplayed()));
        onView(withId(signInButtonId)).perform(click());
        return new MainPage();
    }
}