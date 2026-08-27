package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.edu.qamid.R;

public class MainPage {

    private final int menuButtonId = R.id.main_menu_image_button;
    private final int allNewsButtonId = R.id.all_news_text_view;
    private final int quotesButtonId = R.id.our_mission_image_button;
    private final int profileButtonId = R.id.authorization_image_button;

    private void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MainPage openMenu() {
        waitFor(1000);
        onView(withId(menuButtonId)).check(matches(isDisplayed()));
        onView(withId(menuButtonId)).perform(click());
        return this;
    }

    public NewsPage goToAllNews() {
        waitFor(10000); // Ждём 10 секунд
        onView(withId(allNewsButtonId)).check(matches(isDisplayed()));
        onView(withId(allNewsButtonId)).check(matches(isEnabled()));
        onView(withId(allNewsButtonId)).perform(click());
        return new NewsPage();
    }

    public QuotesPage goToQuotes() {
        waitFor(1000);
        onView(withId(quotesButtonId)).check(matches(isDisplayed()));
        onView(withId(quotesButtonId)).perform(click());
        return new QuotesPage();
    }

    public AuthorizationPage logout() {
        waitFor(1000);
        onView(withId(profileButtonId)).check(matches(isDisplayed()));
        onView(withId(profileButtonId)).perform(click());
        return new AuthorizationPage();
    }
}