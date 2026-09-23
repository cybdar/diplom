package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.edu.qamid.R;

public class ControlPanelPage {

    private final int addButtonId = R.id.add_news_image_view;
    private final int categoryFieldId = R.id.news_category_text_input_layout;
    private final int titleFieldId = R.id.news_title_edit_text;
    private final int dateFieldId = R.id.news_publish_date_edit_text;
    private final int timeFieldId = R.id.news_publish_time_edit_text;
    private final int descriptionFieldId = R.id.news_description_edit_text;
    private final int activeSwitchId = R.id.news_active_switch;
    private final int saveButtonId = R.id.news_save_button;
    private final int cancelButtonId = R.id.news_cancel_button;

    public ControlPanelPage clickAdd() {
        Allure.step("Нажатие на кнопку создания новости");
        onView(withId(addButtonId)).perform(click());
        return this;
    }

    public ControlPanelPage fillCategory(String category) {
        Allure.step("Выбор категории: " + category);
        onView(withId(categoryFieldId)).perform(click());
        onView(withText(category))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
        return this;
    }

    public ControlPanelPage fillTitle(String title) {
        Allure.step("Заполнение заголовка: " + title);
        onView(withId(titleFieldId)).perform(replaceText(title), closeSoftKeyboard());
        return this;
    }

    public ControlPanelPage fillDate(String date) {
        Allure.step("Заполнение даты: " + date);
        onView(withId(dateFieldId)).perform(replaceText(date), closeSoftKeyboard());
        return this;
    }

    public ControlPanelPage fillTime(String time) {
        Allure.step("Заполнение времени: " + time);
        onView(withId(timeFieldId)).perform(replaceText(time), closeSoftKeyboard());
        return this;
    }

    public ControlPanelPage fillDescription(String description) {
        Allure.step("Заполнение описания: " + description);
        onView(withId(descriptionFieldId)).perform(replaceText(description), closeSoftKeyboard());
        return this;
    }

    public ControlPanelPage setActive(boolean active) {
        Allure.step("Установка статуса Active: " + active);
        onView(withId(activeSwitchId)).perform(click());
        return this;
    }

    public NewsPage save() {
        Allure.step("Сохранение новости");
        onView(withId(saveButtonId)).perform(click());
        return new NewsPage();
    }

    public ControlPanelPage cancel() {
        Allure.step("Отмена создания новости");
        onView(withId(cancelButtonId)).perform(click());
        return this;
    }

    public ControlPanelPage checkErrorVisible(String errorText) {
        Allure.step("Проверка ошибки: " + errorText);
        onView(withText(errorText)).check(matches(isDisplayed()));
        return this;
    }

    public ControlPanelPage checkFormVisible() {
        Allure.step("Проверка отображения формы создания новости");
        onView(withText("SAVE")).check(matches(isDisplayed()));
        return this;
    }
}