package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import io.qameta.allure.kotlin.Allure;
import ru.edu.qamid.R;

public class NewsPage {

    private final int filterButtonId = R.id.news_filter_button;
    private final int controlPanelButtonId = R.id.news_edit_button;
    private final int addButtonId = R.id.add_news_image_view;

    private final UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

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
        device.wait(Until.findObject(By.textContains(title)), 10000);
        return this;
    }

    public NewsPage checkErrorToast(String errorText) {
        Allure.step("Проверка всплывающей ошибки: " + errorText);
        device.wait(Until.findObject(By.text(errorText)), 5000);
        return this;
    }

    public NewsPage openFilter() {
        Allure.step("Открытие фильтра новостей");
        onView(withId(filterButtonId)).perform(click());
        return this;
    }

    public NewsPage applyFilter() {
        Allure.step("Нажатие кнопки FILTER");
        onView(withText("FILTER")).perform(click());
        return this;
    }

    public ControlPanelPage openControlPanel() {
        Allure.step("Открытие Control Panel");
        onView(withId(controlPanelButtonId)).perform(click());
        return new ControlPanelPage();
    }
}