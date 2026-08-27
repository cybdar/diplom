package ru.edu.qamid.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.edu.qamid.ui.AppActivity;
import ru.edu.qamid.pages.AuthorizationPage;
import ru.edu.qamid.utils.TestData;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import ru.edu.qamid.R;

@RunWith(AndroidJUnit4.class)
public class AuthorizationTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private AuthorizationPage authPage;

    @Before
    public void setUp() {
        activityRule.getScenario().recreate();

        for (int i = 0; i < 15; i++) {
            try {
                onView(withId(R.id.login_edit_text)).check(matches(isDisplayed()));
                break;
            } catch (Exception e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        authPage = new AuthorizationPage();
    }

    @Test
    public void successfulLogin() {
        authPage
                .enterLogin(TestData.VALID_LOGIN)
                .enterPassword(TestData.VALID_PASSWORD)
                .clickSignIn()
                .goToAllNews();
    }
}