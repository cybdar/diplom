package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.edu.qamid.R;
import ru.edu.qamid.utils.WaitUtils;

public class NewsPage {

    private final int filterButtonId = R.id.news_filter_button;
    private final int controlPanelButtonId = R.id.news_edit_button;
    private final int addButtonId = R.id.add_news_image_view;

    public NewsPage checkNewsScreenVisible() {
        Allure.step("Проверка отображения экрана новостей");
        onView(withId(controlPanelButtonId)).check(matches(isDisplayed()));
        return this;
    }

    public NewsPage checkFilterScreenVisible() {
        Allure.step("Проверка отображения экрана фильтра");
        onView(withText("FILTER")).check(matches(isDisplayed()));
        return this;
    }

    public NewsPage checkControlPanelVisible() {
        Allure.step("Проверка отображения экрана Control Panel (список новостей)");
        onView(withText("Control panel")).check(matches(isDisplayed()));
        onView(withId(addButtonId)).check(matches(isDisplayed()));
        return this;
    }

    public NewsPage checkNewsWithTitleVisible(String title) {
        Allure.step("Проверка отображения новости: " + title);
        onView(isRoot()).perform(WaitUtils.waitForText(title, 10000));
        onView(withSubstring(title)).check(matches(isDisplayed()));
        return this;
    }

    public NewsPage openFilter() {
        Allure.step("Открытие фильтра новостей");
        onView(withId(filterButtonId)).perform(click());
        return this;
    }

    public ControlPanelPage openControlPanel() {
        Allure.step("Открытие Control Panel");
        onView(withId(controlPanelButtonId)).perform(click());
        return new ControlPanelPage();
    }
}