package ru.edu.qamid.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.app.Instrumentation;
import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;

import ru.edu.qamid.R;
import ru.edu.qamid.pages.AuthorizationPage;
import ru.edu.qamid.pages.MainPage;
import ru.edu.qamid.ui.AppActivity;
import ru.edu.qamid.utils.TestData;
import ru.edu.qamid.utils.WaitUtils;

public class BaseTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    protected MainPage mainPage;

    @Before
    public void setUp() {
        disableAnimations();
        waitForAnyScreen();

        if (!isAuthorized()) {
            new AuthorizationPage()
                    .enterLogin(TestData.VALID_LOGIN)
                    .enterPassword(TestData.VALID_PASSWORD)
                    .clickSignIn();
            onView(isRoot()).perform(WaitUtils.waitForView(R.id.all_news_text_view, 10000));
        }

        mainPage = new MainPage();
    }

    private void disableAnimations() {
        Instrumentation inst = InstrumentationRegistry.getInstrumentation();
        inst.getUiAutomation().executeShellCommand("settings put global window_animation_scale 0");
        inst.getUiAutomation().executeShellCommand("settings put global transition_animation_scale 0");
        inst.getUiAutomation().executeShellCommand("settings put global animator_duration_scale 0");
    }

    private void waitForAnyScreen() {
        long endTime = System.currentTimeMillis() + 15000;
        while (System.currentTimeMillis() < endTime) {
            if (isViewVisible(R.id.login_edit_text) || isViewVisible(R.id.all_news_text_view)) {
                return;
            }
            onView(isRoot()).perform(pause(200));
        }
    }

    private boolean isAuthorized() {
        return isViewVisible(R.id.all_news_text_view);
    }

    private boolean isViewVisible(int viewId) {
        try {
            onView(withId(viewId)).check(
                    androidx.test.espresso.assertion.ViewAssertions.matches(
                            androidx.test.espresso.matcher.ViewMatchers.isDisplayed()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private ViewAction pause(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Пауза " + millis + " мс";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }
}