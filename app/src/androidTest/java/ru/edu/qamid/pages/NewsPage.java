package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import io.qameta.allure.kotlin.Allure;
import ru.edu.qamid.R;
import ru.edu.qamid.utils.WaitUtils;

public class NewsPage {

    private final int filterButtonId = R.id.news_filter_button;
    private final int controlPanelButtonId = R.id.news_edit_button;
    private final int addButtonId = R.id.add_news_image_view;
    private final int titleFieldId = R.id.news_title_edit_text;
    private final int filterCategoryFieldId = R.id.filter_news_category_text_input_layout;

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

    public NewsPage checkFormVisible() {
        Allure.step("Проверка отображения формы создания новости (поле Title)");
        onView(isRoot()).perform(WaitUtils.waitForView(titleFieldId, 5000));
        onView(withId(titleFieldId)).check(matches(isDisplayed()));
        return this;
    }

    public NewsPage checkSaveButtonVisible() {
        Allure.step("Проверка, что кнопка SAVE видна (остались на форме)");
        onView(withId(R.id.news_save_button)).check(matches(isDisplayed()));
        return this;
    }

    public NewsPage checkNewsWithTitleVisible(String title) {
        Allure.step("Проверка отображения новости: " + title);
        device.waitForIdle();
        UiScrollable list = new UiScrollable(new UiSelector().scrollable(true));
        try {
            list.scrollIntoView(new UiSelector().textContains(title));
        } catch (UiObjectNotFoundException e) {
            throw new AssertionError("Новость <" + title + "> не найдена в списке");
        }
        return this;
    }

    public NewsPage openFilter() {
        Allure.step("Открытие фильтра новостей");
        onView(withId(filterButtonId)).perform(click());
        return this;
    }

    public NewsPage selectCategoryInFilter(String category) {
        Allure.step("Выбор категории в фильтре: " + category);
        onView(withId(filterCategoryFieldId)).perform(click());
        onView(withText(category))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
        return this;
    }

    public NewsPage applyFilter() {
        Allure.step("Нажатие кнопки FILTER");
        onView(withText("FILTER")).perform(click());
        return this;
    }

    public NewsPage cancelFilter() {
        Allure.step("Нажатие кнопки CANCEL в фильтре");
        onView(withText("CANCEL")).perform(click());
        return this;
    }

    public ControlPanelPage openControlPanel() {
        Allure.step("Открытие Control Panel");
        onView(isRoot()).perform(WaitUtils.waitForView(controlPanelButtonId, 10000));
        onView(withId(controlPanelButtonId)).perform(click());
        return new ControlPanelPage();
    }

    public ControlPanelPage clickEditOnFirstNews() {
        Allure.step("Клик на кнопку редактирования первой новости");
        UiObject2 editButton = device.findObject(By.res("ru.edu.qamid", "news_item_edit_image_view"));
        if (editButton != null) {
            editButton.click();
        } else {
            throw new AssertionError("Кнопка редактирования не найдена");
        }
        return new ControlPanelPage();
    }
}