package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.edu.qamid.R;

public class NewsPage {

    private final int filterButtonId = R.id.news_filter_button;
    private final int controlPanelButtonId = R.id.news_edit_button;

    public NewsPage openFilter() {
        onView(withId(filterButtonId)).perform(click());
        return this;
    }

    public ControlPanelPage openControlPanel() {
        onView(withId(controlPanelButtonId)).perform(click());
        return new ControlPanelPage();
    }
}