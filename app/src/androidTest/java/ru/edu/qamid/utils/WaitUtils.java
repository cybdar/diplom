package ru.edu.qamid.utils;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Matcher;

import java.util.concurrent.TimeoutException;

public class WaitUtils {

    public static ViewAction waitForView(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isRoot();
            }

            @Override
            public String getDescription() {
                return "Ожидание элемента id <" + viewId + "> в течение " + millis + " мс";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;

                Matcher<View> matchId = ViewMatchers.withId(viewId);
                Matcher<View> matchDisplayed = ViewMatchers.isDisplayed();

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (matchId.matches(child) && matchDisplayed.matches(child)) {
                            return;
                        }
                    }
                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                throw new RuntimeException(new TimeoutException(
                        "Элемент id <" + viewId + "> не появился за " + millis + " мс"));
            }
        };
    }

    public static ViewAction waitForView(final int viewId) {
        return waitForView(viewId, 5000);
    }

    public static ViewAction waitForText(final String text, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isRoot();
            }

            @Override
            public String getDescription() {
                return "Ожидание текста <" + text + "> в течение " + millis + " мс";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;

                Matcher<View> matchText = ViewMatchers.withText(text);
                Matcher<View> matchDisplayed = ViewMatchers.isDisplayed();

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (matchText.matches(child) && matchDisplayed.matches(child)) {
                            return;
                        }
                    }
                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                throw new RuntimeException(new TimeoutException(
                        "Текст <" + text + "> не появился за " + millis + " мс"));
            }
        };
    }

    public static ViewAction waitForText(final String text) {
        return waitForText(text, 5000);
    }
}